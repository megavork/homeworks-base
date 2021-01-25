package Market_11.Market;

import Market_11.converter.HeyJackson;
import Market_11.Source.Item;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;

public class Market {
    MarketBase base;

    public Market() {
        base = new MarketBase();
        base.generateItems();
    }

    public boolean checkAction() throws JAXBException, IOException {
        int number = CustomerInput.getIntegerInputAnswer("options number");

        switch (number) {
            case 1:
                base.sortPriceChecker();
                return true;
            case 2:
                base.sortByPriceAscendingOrder();
                return true;
            case 3:
                base.sortByAdditionDate();
                return true;
            case 4:
                base.setItemToBase();
                return true;
            case 5:
                base.removeItemFromBase();
                return true;
            case 6:
                base.editItem();
                return true;
            case 7:
                marshallItems();
                return true;
            case 8:
                HeyJackson.toJSON(base.getBase());
                return true;
            case 0:
                return false;
            default:
                System.out.println("Wrong answer. Try again.");
                return true;
        }
    }

    public MarketBase getBase() {
        return base;
    }

    public void marshallItems() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(this.base.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(this.getBase(), System.out);
        System.out.println("");
    }
}
