package EnvLikeSpotify;


import java.util.Iterator;

public class LL {
    private Person head;
    private Person tail;

    public LL() {
        head = null;
        tail = null;
    }

    public boolean contains(String PersonName) {
        Person current = head;
        while (current != null) {
            if (current.getPersonName().equals(PersonName))
                return true;

            current = current.getNext();
        }
        return false;
    }

    public void addFirst(String PersonName) {
        Person newPerson = new Person(PersonName);
        if (IsFull()) {
            //liste dolu
            newPerson.setNext(head);
            head = newPerson;

        } else {
            //liste bo�
            head = newPerson;
            tail = newPerson;
        }
    }

    public void addEnd(String PersonName) {
        Person newPerson = new Person(PersonName);
        if (IsFull()) {
            //liste dolu
            tail.setNext(newPerson);
            tail = newPerson;
        } else {
            //liste bos
            head = newPerson;
            tail = newPerson;
        }
    }

    public void addIndex(String PersonName, int indeks) {
        Person newPerson = new Person(PersonName);
        if (IsFull()) {
            //liste dolu
            if (indeks == 0) {
                //basa eklemekle ayni
                newPerson.setNext(head);
                head = newPerson;
            } else {
                //ortada bi yere ekliyoruz
                Person pointer1 = null;
                Person pointer2 = head;
                int availableIndeks = 0;
                while (pointer2 != null && availableIndeks < indeks) {
                    pointer1 = pointer2;
                    pointer2 = pointer2.getNext();
                    availableIndeks++;
                }
                if (pointer2 == null) {
                    //listenin sonuna ekle
                    tail.setNext(newPerson);
                    tail = newPerson;
                } else {
                    //ortada bir yere ekliyor
                    newPerson.setNext(pointer2);
                    pointer1.setNext(newPerson);
                }
            }
        } else {
            //liste bos
            head = newPerson;
            tail = newPerson;
        }

    }

    public void EreaseFirst() {
        if (IsFull()) {
            if (head == tail) {
                //listede tek Person var
                head = null;
                tail = null;
            } else {
                Person newHead = head.getNext();
                head.setNext(null);
                head = newHead;
            }
        }
    }

    public boolean remove(String PersonName) {
        Person previous = null;
        Person current = head;

        while (head != null) {
            if (current.getPersonName().equals(PersonName)) {
                if (previous != null) {
                    previous.setNext(current.getNext());

                    if (current.getNext() == null) {
                        tail = previous;
                    }
                } else {
                    head = current.getNext();

                    if (head == null) {
                        tail = null;
                    }
                }

                //  --size;
                return true;
            }

            previous = current;
            current = current.getNext();
        }

        return false;
    }

    public int size() {
        Person pointer = head;
        int PersonNumber = 0;
        while (pointer != null) {
            PersonNumber++;
            pointer = pointer.getNext();

        }
        return PersonNumber;
    }

    public void EraseEnd() {
        if (IsFull()) {
            if (head == tail) {
                //listede tek Person var
                head = null;
                tail = null;
            } else {
                Person pointer = head;
                while (pointer.getNext() != tail) {
                    pointer = pointer.getNext();
                }
                pointer.setNext(null);
                tail = pointer;
            }
        }
    }

    public void EreaseIndex(int indeks) {
        if (IsFull() && indeks >= 0) {
            if (head == tail) {
                //tek Person var
                head = null;
                tail = null;
            } else {
                //en az iki Person var
                if (indeks == 0) {
                    //bastakini sil
                    Person newHead = head.getNext();
                    head.setNext(null);
                    head = newHead;
                } else {
                    //en az 2 Person var ve sildigimiz basta degil
                    Person pointer1 = null;
                    Person pointer2 = head;
                    int availableIndeks = 0;
                    while (pointer2 != null && availableIndeks < indeks) {
                        pointer1 = pointer2;
                        pointer2 = pointer2.getNext();
                        availableIndeks++;
                    }
                    if (pointer2 != null) {
                        //ortadan veya sondan silme
                        Person pointer3 = pointer2.getNext();
                        pointer2.setNext(null);
                        pointer1.setNext(pointer3);
                    }
                }
            }
        }
    }

    public void EreaseAvailableValue(String PersonName) { //ayni degeri bir kere siler
        if (IsFull()) {
            if (head == tail) {
                //tek Person var
                if (head.getPersonName().equals(PersonName)) {
                    head = null;
                    tail = null;
                }
            } else {
                //en az iki Person var
                if (head.getPersonName().equals(PersonName)) {
                    //ba�takini sil
                    Person newHead = head.getNext();
                    head.setNext(null);
                    head = newHead;
                } else {
                    //en az 2 Person var ve sildigimiz basta degil
                    Person pointer1 = null;
                    Person pointer2 = head;
                    while (pointer2 != null && !(pointer2.getPersonName().equals(PersonName)) ) {
                        pointer1 = pointer2;
                        pointer2 = pointer2.getNext();
                    }
                    if (pointer2 != null) {
                        if (pointer2 == tail) {
                            //sondan silme
                            tail = pointer1;
                            pointer1.setNext(null);
                        } else {
                            //ortadan silme
                            Person pointer3 = pointer2.getNext();
                            pointer2.setNext(null);
                            pointer1.setNext(pointer3);
                        }
                    }
                }
            }
        }
    }

    public void EreaseAllAvailableValue(String PersonName) { //ayni deger kac kere geciyorsa hepsini siler
        if (IsFull()) {
            if (head == tail) {
                //tek Person var
                if (head.getPersonName().equals(PersonName)) {
                    head = null;
                    tail = null;
                }
            } else {
                Person pointer1 = null;
                Person pointer2 = head;

                while (pointer2 != null) {
                    if (pointer2.getPersonName().equals(PersonName) ) {
                        if (head == pointer2) {
                            head = pointer2.getNext();
                            pointer2.setNext(null);
                            pointer2 = head;
                        } else {
                            if (pointer2 == tail) {
                                //sondan silme
                                tail = pointer1;
                                pointer1.setNext(null);
                                pointer2 = null;
                            } else {
                                //ortadan sil
                                Person pointer3 = pointer2.getNext();
                                pointer2.setNext(null);
                                pointer1.setNext(pointer3);
                                pointer2 = pointer3;
                            }
                        }
                    } else {
                        //Person silmiyorsak
                        //isaretcileri guncelle
                        pointer1 = pointer2;
                        pointer2 = pointer2.getNext();
                    }
                }
            }
        }
    }

    public int count(String search_for) {
        Person current = head;
        int count = 0;
        while (current != null) {
            if (current.getPersonName().equals(search_for))
                count++;
            current = current.getNext();
        }
        return count;
    }

    public Iterator<String> iterator() {
        return new Iterator<>() {

            Person current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public String next() {
                if (hasNext()) {
                    String PersonName = current.getPersonName();
                    current = current.getNext();
                    return PersonName;
                }
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove not implemented.");
            }

        };

    }

    public String get(int i) {
        int n = indexOf(head); // count-1 actually
        Person current = head;
        while (n > i) {
            --n;
            current = current.getNext();
        }
        return current.getPersonName();
    }

    public int indexOf(Person p) {
        if (p == null) {
            return -1;
        }
        return 1 + indexOf(p.getNext());
    }

    public void printList() {
        Person pointer = head;
        while (pointer != null) {
            System.out.println(pointer.getPersonName() + " ");
            pointer = pointer.getNext();
        }
    }

    public boolean IsFull() {
        return head!=null;
    }
}
