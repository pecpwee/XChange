package info.bitrich.xchangestream.binance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.binance.dto.marketdata.BinanceKline;
import org.knowm.xchange.binance.dto.marketdata.BinanceKlineBuilder;
import org.knowm.xchange.binance.dto.marketdata.KlineInterval;
import org.knowm.xchange.currency.CurrencyPair;

import java.math.BigDecimal;

/***
 *
 * relative docs:https://binance-docs.github.io/apidocs/futures/en/#kline-candlestick-streams
 */
public class KlineBinanceWebsocketTransaction {

    private CurrencyPair currencyPair;
    private PayLoadData payLoadData;


    public CurrencyPair getCurrencyPair() {
        return currencyPair;
    }

    public BinanceKline getBinanceKLine() {
        return this.payLoadData.getKline();
    }


    public KlineBinanceWebsocketTransaction(
            @JsonProperty("e") String eventType,
            @JsonProperty("E") Long eventTime,
            @JsonProperty("s") String symbol,
            @JsonProperty("k") PayLoadData klineData
    ) {

        this.currencyPair = BinanceAdapters.adaptSymbol(symbol);
        this.payLoadData = klineData;
    }

    public static class PayLoadData {


        private BinanceKline kline;

        public BinanceKline getKline() {
            return kline;
        }

        public PayLoadData(
                @JsonProperty("t") Long startTime,
                @JsonProperty("T") Long closeTime,
                @JsonProperty("s") String symbol,
                @JsonProperty("i") String interval,
                @JsonProperty("f") Long firstTradeId,
                @JsonProperty("L") Long lastTradeId,
                @JsonProperty("o") String openPrice,
                @JsonProperty("c") String closePrice,
                @JsonProperty("h") String highPrice,
                @JsonProperty("l") String lowPrice,
                @JsonProperty("v") String baseAssetVolume,
                @JsonProperty("n") Long numberOfTrades,
                @JsonProperty("x") Boolean isKlineClosed,
                @JsonProperty("q") String quoteAssetVolume,
                @JsonProperty("V") String takerBuyBaseAssetVolume,
                @JsonProperty("Q") String takerBuyQuoteAssetVolume,
                @JsonProperty("B") String ignoreString
        ) {

            this.kline = new BinanceKlineBuilder()
                    .setOpenTime(startTime)
                    .setCloseTime(closeTime)
                    .setPair(BinanceAdapters.adaptSymbol(symbol))
                    .setInterval(KlineInterval.valueOf(interval))
                    .setOpen(new BigDecimal(openPrice))
                    .setClose(new BigDecimal(closePrice))
                    .setHigh(new BigDecimal(highPrice))
                    .setLow(new BigDecimal(lowPrice))
                    .setQuoteAssetVolume(new BigDecimal(quoteAssetVolume))
                    .setTakerBuyBaseAssetVolume(new BigDecimal(takerBuyBaseAssetVolume))
                    .setTakerBuyQuoteAssetVolume(new BigDecimal(takerBuyQuoteAssetVolume))


                    .createBinanceKline();


        }
    }
}
