package managers;

import java.io.File;

public class Manager {

    public static ShopManager shopManager = new ShopManager();

    public ShopManager getDefault(){
        return shopManager;
    }

    public FileBackendGoodsManager getFileBackendDefault(){
        return new FileBackendGoodsManager();
    }

}
