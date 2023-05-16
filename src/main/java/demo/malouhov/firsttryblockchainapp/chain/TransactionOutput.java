package demo.malouhov.firsttryblockchainapp.chain;

import demo.malouhov.firsttryblockchainapp.util.BlockUtil;

import java.security.PublicKey;

public class TransactionOutput {
    private String id;
    private PublicKey reciepient; //also known as the new owner of these coins.
    private float value; //the amount of coins they own
    private String parentTransactionId; //the id of the transaction this output was created in

    //Constructor
    public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
        this.reciepient = reciepient;
        this.value = value;
        this.parentTransactionId = parentTransactionId;
        this.id = BlockUtil.applySha256(BlockUtil.getStringFromKey(reciepient)+Float.toString(value)+parentTransactionId);
    }

    public String getId() {
        return id;
    }

    public PublicKey getReciepient() {
        return reciepient;
    }

    public float getValue() {
        return value;
    }

    //Check if coin belongs to you
    public boolean isMine(PublicKey publicKey) {
        return (publicKey == reciepient);
    }

}
