package managers;

import exceptions.ManagerSaveException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FileBackendGoodsManager extends ShopManager{

    public FileBackendGoodsManager() {
    }

    @Override
    public void createGood(Good good) throws ManagerSaveException {
        super.createGood(good);
        save();
    }

    File file = new File("src/files", "SavedGoods.csv");;

//    public FileBackendGoodsManager(File file) {
//        this.file = file;
//    }

    public void save(){
        try{
            if(!Files.exists(file.toPath())) {
                Files.createFile(file.toPath());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("id,name,price,rating,category\n");
            for(Good good : goods.values()){
                System.out.println(good);
                bw.write(good.toString() + "\n");
            }

        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи товаров");
            throw new RuntimeException(e);
        }
    }
}
