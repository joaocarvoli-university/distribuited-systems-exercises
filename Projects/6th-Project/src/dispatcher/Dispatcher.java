package dispatcher;
import data.DataHandlingServices;
import skeleton.SKCalculator;

public class Dispatcher {
    public String invoke(String message){
        String service = DataHandlingServices.ServiceSelector(message);
        if(service.equals("Calculator"))
        {
            SKCalculator calc = new SKCalculator(message);
            return calc.doCalc();
        }
        /*else if(service.equals("CurrencyConverter")) {
            CurrencyConverter converter = new CurrencyConverter();
            DataHandlingConverse dataHandled = new DataHandlingConverse(message);

            if((dataHandled.getCurrency()).equals("Dollar"))
            {
                result = converter.DollarToReal(dataHandled.getRealValue(),dataHandled.getDollarValue());
            }
            else if((dataHandled.getCurrency()).equals("Real"))
            {
                result = converter.RealToDollar(dataHandled.getRealValue(),dataHandled.getDollarValue());
            }
            return String.valueOf(result);
        } */
        return null;
    }
}
