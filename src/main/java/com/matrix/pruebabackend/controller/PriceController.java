package com.matrix.pruebabackend.controller;

@RestController
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private PriceRepository priceRepository;

    @GetMapping
    public PriceDto getPrice(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime date,
                             @RequestParam("productId") Long productId,
                             @RequestParam("brandId") Long brandId) {
        List<Price> prices = priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                brandId, productId, date, date);
        if (prices.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Price not found");
        }
        Price price = prices.get(0);
        PriceDto priceDto = new PriceDto();
        priceDto.setBrandId(price.getBrandId());
        priceDto.setProductId(price.getProductId());
        priceDto.setPrice(price.getPrice
