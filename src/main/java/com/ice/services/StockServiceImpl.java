package com.ice.services;

import com.ice.domain.Stock;
import com.ice.repository.StockRepository;

import java.util.List;

/**
 * Created by Chaitanya on 12/7/16.
 */
public class StockServiceImpl implements StockService{

    @Override
    public List<Stock> savePortfolio(List<Stock> stocks, StockRepository stockRepository) {
        System.out.println("Saving: ");
        stockRepository.save(stocks);
        return stockRepository.findAll();
    }

    @Override
    public List<Stock> getSavedPortfolios(StockRepository stockRepository) {
        return stockRepository.findAll();
    }


    @Override
    public Stock updateStock(Stock stock, StockRepository stockRepository) {
        Stock stockToBeUpdated = stockRepository.findOne(stock.getId());
        stockToBeUpdated.setNumberOfShares(stock.getNumberOfShares());
        stockRepository.save(stockToBeUpdated);
        return stockToBeUpdated;
    }

    @Override
    public List<Stock> deleteStock(Long id, StockRepository stockRepository) {
        stockRepository.delete(id);
        return stockRepository.findAll();
    }


}
