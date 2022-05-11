package src.services;

public class CurrencyConverter {
    public double RealToDollar(Double realValue, Double dollarValue){
        return realValue/ dollarValue;
    }

    public double DollarToReal(Double realValue, Double dollarValue){
        return dollarValue*dollarValue;
    }
}
