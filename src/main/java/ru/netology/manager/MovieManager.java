package ru.netology.manager;

import ru.netology.domain.CatalogMovie;

public class MovieManager {
    private CatalogMovie[] catalogs = new CatalogMovie[0];
    private int limit = 10;

    public MovieManager(){}
    public MovieManager(int lim) {
        if (lim < 10){
        this.limit = lim;
        } else this.limit = 10;
    }

    public void add(CatalogMovie catalog) {
        // создаём новый массив размером на единицу больше
        int length = catalogs.length + 1;
        CatalogMovie[] tmp = new CatalogMovie[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < catalog.length; i++) {
        //   tmp[i] = catalog[i];
        // }
        System.arraycopy(catalogs, 0, tmp, 0, catalogs.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = catalog;
        catalogs = tmp;
    }

    public CatalogMovie[] getLast() {
        int resultLength;
        if (catalogs.length > limit) {
            resultLength = limit;
        } else {
            resultLength = catalogs.length;
        }
        CatalogMovie[] result = new CatalogMovie[resultLength];
        for (int i = 0; i < result.length; i++){
            int index = catalogs.length - i - 1;
            result[i] = catalogs[index];
        } return  result;
    }

   /* public CatalogMovie[] getAll() {
        CatalogMovie[] showCatalog = new CatalogMovie[catalogs.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < showCatalog.length; i++) {
            int index = catalogs.length - i - 1;
            showCatalog[i] = catalogs[index];
        }
        return showCatalog;
    }

    // наивная реализация
    public void removeById(int id) {
        int length = catalogs.length - 1;
        CatalogMovie[] tmp = new CatalogMovie[length];
        int index = 0;
        for (CatalogMovie catalog : catalogs) {
            if (catalog.getId() != id) {
                tmp[index] = catalog;
                if (index < length - 1) {
                    index++;
                }
            }
        }
        // меняем наши элементы
        catalogs = tmp;
    }*/
}
