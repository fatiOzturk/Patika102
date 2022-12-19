public class MyList <T> {
    private T [] array;
    private int index = 0;
    private int capacity;


    public MyList() {
        this.capacity =10;
        this.array = (T[]) new Object[this.capacity];
    }
    public MyList(int capacity){
        if (capacity>0){
            this.capacity=capacity;
        } else {
            this.capacity=10;
        }
        this.array = (T[]) new Object[this.capacity];
    }
    public int size (){
        return this.getIndex();
    }
    // add(T data) : Sınıfa ait diziye eleman ekler. Eğer dizide yeteri kadar yer yok ise, dizi boyutunu 2 katına çıkartır.
    public void add(T data) {
        if (this.getIndex() == this.getCapacity()) {
            this.setCapacity(this.getCapacity() * 2);

            T[] tempArray = (T[]) new Object[this.getCapacity()];

            int i = 0;
            for (T arr : this.getArray()) {
                tempArray[i] = arr;
                i++;
            }
            this.setArray(tempArray);
        }
        this.setArray(this.getIndex(),data);
        this.setIndex(this.getIndex() + 1);
    }
    // get(int index): verilen indisteki değeri döndürür. Geçersiz indis girilerse null döndürür.
    public T get(int index) {
        if (this.getIndex() > index) {
            return this.getArray()[index];
        } else {
            return null;
        }
    }

    // remove(int index): verilen indisteki veriyi siler ve verileri sola doğru kaydırır. Geçersiz indis'te null döndürür.
    public T remove(int index) {
        if (this.getIndex() > index) {
            T deletedValue = this.getArray()[index];
            for (int i = index; i < this.getIndex(); i++) {
                this.setArray(i,this.getArray()[i+1]);
            }
            this.setArray(size(),null);
            this.setIndex(this.getIndex() - 1);
            return deletedValue;
        }
        return null;
    }

    // set(int index, T data) : verilen indisteki veriyi yenisi ile değiştirir. Geçersiz indis girilerse null döndürür.
    public T set(int index, T data) {
        if (this.getIndex() > index) {
            this.setArray(index,data);
            return this.getArray()[index];
        }
        return null;
    }

    // String toString() : Sınıfa ait dizideki elemanları listeleyen bir metot.

    @Override
    public String toString() {
        String listArray = "[";
        for (int i = 0; i < size(); i++) {
            listArray += (this.getArray()[i].toString());
            if (i != size() - 1) {
                listArray += " ";
            }
        }
        listArray += "]";
        return listArray;
    }

    // int indexOf(T data) : Parametrede verilen nesnenin listedeki indeksini verir. Nesne listede yoksa -1 değerini verir.
    public int indexOf(T data){
        int index = 0;
        for(T item:this.getArray()){
            if ( item == data)
                return index;
            index ++;
        }
        return -1;
    }

    // int lastIndexOf(T data) : Belirtilen öğenin listedeki son indeksini söyler. Nesne listede yoksa -1 değerini verir.
    public int lastIndexOf(T data) {
        for (int i = this.getIndex() - 1; i >= 0; i--) {
            if (this.getArray()[i] == data)
                return i;
        }
        return -1;
    }

    // boolean isEmpty() : Listenin boş olup olmadığını söyler.
    public boolean isEmpty() {
        return this.getIndex() == 0;
    }

    // T[] toArray() : Listedeki öğeleri, aynı sırayla bir array haline getirir.
    public T[] toArray() {
        return this.getArray();
    }

    // clear() : Listedeki bütün öğeleri siler, boş liste haline getirir.
    public void clear() {
        this.setIndex(0);
        this.setCapacity(10);
        this.setArray((T[]) new Object[this.capacity]);
    }

    // MyList<T> sublist(int start,int finish) : Parametrede verilen indeks aralığına ait bir liste döner.
    public MyList<T> subList(int start, int finish) {
        MyList<T> subList = new MyList<>(finish - start + 1);

        for (int i = start; i <= finish; i++) {
            subList.add(this.getArray()[i]);
        }

        return subList;
    }

    // boolean contains(T data) : Parametrede verilen değerin dizide olup olmadığını söyler.
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }
    public void setArray(int index, T data){
        this.array[index] = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        if (index>=0){
            this.index = index;
        } else {
            this.index = this.getIndex();
        }

    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity>=0){
            this.capacity = capacity;
        }
    }
}
