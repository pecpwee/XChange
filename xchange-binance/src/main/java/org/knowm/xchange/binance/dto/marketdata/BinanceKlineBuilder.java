package org.knowm.xchange.binance.dto.marketdata;

import org.knowm.xchange.currency.CurrencyPair;

import java.math.BigDecimal;

public class BinanceKlineBuilder {
    private CurrencyPair pair;
    private KlineInterval interval;
    private Object[] obj;
    private long openTime;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal volume;
    private long closeTime;
    private BigDecimal quoteAssetVolume;
    private long numberOfTrades;
    private BigDecimal takerBuyBaseAssetVolume;
    private BigDecimal takerBuyQuoteAssetVolume;

    public BinanceKlineBuilder setPair(CurrencyPair pair) {
        this.pair = pair;
        return this;
    }

    public BinanceKlineBuilder setInterval(KlineInterval interval) {
        this.interval = interval;
        return this;
    }

    public BinanceKlineBuilder setObj(Object[] obj) {
        this.obj = obj;
        return this;
    }

    public BinanceKlineBuilder setOpenTime(long openTime) {
        this.openTime = openTime;
        return this;
    }

    public BinanceKlineBuilder setOpen(BigDecimal open) {
        this.open = open;
        return this;
    }

    public BinanceKlineBuilder setHigh(BigDecimal high) {
        this.high = high;
        return this;
    }

    public BinanceKlineBuilder setLow(BigDecimal low) {
        this.low = low;
        return this;
    }

    public BinanceKlineBuilder setClose(BigDecimal close) {
        this.close = close;
        return this;
    }

    public BinanceKlineBuilder setVolume(BigDecimal volume) {
        this.volume = volume;
        return this;
    }

    public BinanceKlineBuilder setCloseTime(long closeTime) {
        this.closeTime = closeTime;
        return this;
    }

    public BinanceKlineBuilder setQuoteAssetVolume(BigDecimal quoteAssetVolume) {
        this.quoteAssetVolume = quoteAssetVolume;
        return this;
    }

    public BinanceKlineBuilder setNumberOfTrades(long numberOfTrades) {
        this.numberOfTrades = numberOfTrades;
        return this;
    }

    public BinanceKlineBuilder setTakerBuyBaseAssetVolume(BigDecimal takerBuyBaseAssetVolume) {
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
        return this;
    }

    public BinanceKlineBuilder setTakerBuyQuoteAssetVolume(BigDecimal takerBuyQuoteAssetVolume) {
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
        return this;
    }

    public BinanceKline createBinanceKline() {
        return new BinanceKline(pair, interval, openTime, open, high, low, close, volume, closeTime
                , quoteAssetVolume, numberOfTrades, takerBuyBaseAssetVolume, takerBuyQuoteAssetVolume);
    }
}