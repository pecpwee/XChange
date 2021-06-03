package info.bitrich.xchangestream.binance.dto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.knowm.xchange.binance.dto.marketdata.BinanceKline;
import org.junit.Assert;
import org.knowm.xchange.binance.dto.marketdata.KlineInterval;

import java.io.IOException;
import java.io.InputStream;

public class KlineBinanceWebsocketTransactionTest {

    private static ObjectMapper mapper;

    @BeforeClass
    public static void setupClass() {
        mapper = new ObjectMapper();

    }

    @Test
    public void test_deserialization_of_transaction_message() throws IOException {
        InputStream stream =
                KlineBinanceWebsocketTransactionTest.class.getResourceAsStream("testKlineEvent.json");
        KlineBinanceWebsocketTransaction transaction =
                mapper.readValue(stream, KlineBinanceWebsocketTransaction.class);
        BinanceKline binanceKline = transaction.getBinanceKLine();
        Assert.assertNotNull(binanceKline);
        Assert.assertEquals(binanceKline.getInterval().code(), (KlineInterval.m1.code()));
    }


}
