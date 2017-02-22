class HashEntry{
        int key;
        int value;
        public HashEntry(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    class HashMap{
        private final static int size = 128;
        private HashEntry [] table;
        public HashMap {
            table = new HashEntry[size];
        }

        public void set(int key, int value){
            int hash = key % size;
            while(table[hash] != null && table[hash].key != key){
                hash = (hash + 1) % size;
            }
            table[hash] = new HashEntry(key, value);
        }

        public int get(int key, int value){
            int hash = key % size;
            while(table[hash] != null && table[hash].key != key){
                hash = (hash + 1) % size;
            }
            if(table[hash] == null)
                return -1;
            return table[hash].value;
        }
    }