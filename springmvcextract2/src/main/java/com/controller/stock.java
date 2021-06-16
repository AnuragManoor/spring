package com.controller;

import java.sql.Timestamp;

public class stock {
private Timestamp Time;
private String Symbol;
private String Putorcall;
private String Sentiment;
private String OptionSymbol;
private String TradeType;
private int DTE;
private float StrikePrice;
private int Capa;
private int TradeCount;
private float TotalTradePrice;
private float Option_Price;
private int OI;
private int Volume;
private float VolByOI;
public Timestamp getTime() {
	return Time;
}
public void setTime(Timestamp time) {
	Time = time;
}
public String getSymbol() {
	return Symbol;
}
public void setSymbol(String symbol) {
	Symbol = symbol;
}
public String getPutorcall() {
	return Putorcall;
}
public void setPutorcall(String putorcall) {
	Putorcall = putorcall;
}
public String getSentiment() {
	return Sentiment;
}
public void setSentiment(String sentiment) {
	Sentiment = sentiment;
}
public String getOptionSymbol() {
	return OptionSymbol;
}
public void setOptionSymbol(String optionSymbol) {
	OptionSymbol = optionSymbol;
}
public String getTradeType() {
	return TradeType;
}
public void setTradeType(String tradeType) {
	TradeType = tradeType;
}
public int getDTE() {
	return DTE;
}
public void setDTE(int dTE) {
	DTE = dTE;
}
public float getStrikePrice() {
	return StrikePrice;
}
public void setStrikePrice(float strikePrice) {
	StrikePrice = strikePrice;
}
public int getCapa() {
	return Capa;
}
public void setCapa(int capa) {
	Capa = capa;
}
public int getTradeCount() {
	return TradeCount;
}
public void setTradeCount(int tradeCount) {
	TradeCount = tradeCount;
}
public float getTotalTradePrice() {
	return TotalTradePrice;
}
public void setTotalTradePrice(float totalTradePrice) {
	TotalTradePrice = totalTradePrice;
}
public float getOption_Price() {
	return Option_Price;
}
public void setOption_Price(float option_Price) {
	Option_Price = option_Price;
}
public int getOI() {
	return OI;
}
public void setOI(int oI) {
	OI = oI;
}
public int getVolume() {
	return Volume;
}
public void setVolume(int volume) {
	Volume = volume;
}
public float getVolByOI() {
	return VolByOI;
}
public void setVolByOI(float volByOI) {
	VolByOI = volByOI;
}
@Override
public String toString() {
	return "stock [Time=" + Time + ", Symbol=" + Symbol + ", Putorcall=" + Putorcall + ", Sentiment=" + Sentiment
			+ ", OptionSymbol=" + OptionSymbol + ", TradeType=" + TradeType + ", DTE=" + DTE + ", StrikePrice="
			+ StrikePrice + ", Capa=" + Capa + ", TradeCount=" + TradeCount + ", TotalTradePrice=" + TotalTradePrice
			+ ", Option_Price=" + Option_Price + ", OI=" + OI + ", Volume=" + Volume + ", VolByOI=" + VolByOI + "]";
}


}
