package DesignPattern;

interface  MyIterator {
    public boolean hasElement();  // or hasNext()
    public Object next();
}

interface Container {
    public MyIterator getIterator();
}

class NameRepository implements  Container {

    public String names[] = {"Achal", "Rohan", "Yogesh", "Preeti", "Abdul"};

    @Override
    public MyIterator getIterator() {
        return new NameIterator();
    }
    private class NameIterator implements MyIterator {
        int index;

        @Override
        public boolean hasElement() {
            if(index < names.length)
                return true;
            return false;
        }

        @Override
        public Object next() {
            if(this.hasElement()) {
                return names[index++];
            }
            return null;
        }
    }
}

public class IteratorDesignPattern {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        MyIterator iter = new NameRepository().getIterator();
        while (iter.hasElement()) {
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }
    }
}
