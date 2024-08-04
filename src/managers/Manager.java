package managers;

import java.io.File;

public class Manager {
    public ShopManager getDefault(){
        return new ShopManager();
    }

    public FileBackendGoodsManager getFileBackendDefault(){
        return new FileBackendGoodsManager();
    }

}
