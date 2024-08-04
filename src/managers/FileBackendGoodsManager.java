package managers;

import exceptions.ManagerSaveException;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileBackendGoodsManager extends ShopManager{

    public FileBackendGoodsManager() {
    }

    @Override
    public void createGood(Good good) throws ManagerSaveException {
        super.createGood(good);
        save();
    }

    File file = new File("src/files", "SavedGoods.csv");;

    public FileBackendGoodsManager(File file) {
        this.file = file;
    }

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

    private static Good fromString(String value){
        String[] entryArray = value.split(",");
        Good good;
        goodId = Integer.parseInt(entryArray[0]);
        good = new Good(entryArray[1], Double.parseDouble(entryArray[2]), Double.parseDouble(entryArray[3]), Integer.parseInt(entryArray[4]));
        good.setId(goodId);
        return good;
    }

    public static Object loadFromFile(File file){
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            FileBackendGoodsManager fb = new FileBackendGoodsManager(new File(file.getPath()));
            List<String> goodsStrings = new ArrayList<>();
            while (br.ready()){
                goodsStrings.add(br.readLine());
            }

            for (int i = 1; i < goodsStrings.size(); i++) {
                goods.put(fromString(goodsStrings.get(i)).getId(), fromString(goodsStrings.get(i)));
            }
            return fb;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
