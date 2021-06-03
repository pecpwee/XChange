package info.bitrich.xchangestream.binance;

public enum BinanceSubscriptionType {
  DEPTH("depth"),
  TRADE("trade"),
  TICKER("ticker"),
  KLINE("kline");

  private String type;

  BinanceSubscriptionType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
