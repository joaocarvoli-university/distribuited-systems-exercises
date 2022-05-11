package services;

public class CurrencyConverter {

    private static CurrencyConverter converter;

    private CurrencyConverter(){}

    public static CurrencyConverter getInstance(){
        if(converter == null){
            converter = new CurrencyConverter();
        }
        return converter;
    }

    public double RealToDollar(Double realValue, Double dollarValue){
        return realValue/ dollarValue;
    }

    public double DollarToReal(Double realValue, Double dollarValue){
        return dollarValue*dollarValue;
    }
}
