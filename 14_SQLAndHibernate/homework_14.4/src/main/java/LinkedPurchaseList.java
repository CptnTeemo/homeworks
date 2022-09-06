import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {

    LinkedPurchaseListKey keyId;

    @EmbeddedId
    public LinkedPurchaseListKey getKeyId() {
        return keyId;
    }

    public void setKeyId(LinkedPurchaseListKey keyId) {
        this.keyId = keyId;
    }

}
