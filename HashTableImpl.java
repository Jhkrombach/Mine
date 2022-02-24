package edu.yu.cs.com1320.project;
import org.w3c.dom.Node;
public class HashTableImpl implements HashTable
{
    Key key;
    Value value;
    Node entry;
    Node next;
    private Entry<?,?>[] hashTable;
    public <T,S> HashTableImpl(T key, S value)
    {
        this.hashTable = new Entry[5];
        int tableKey = key.hashCode();
        for(int p=0; p<5; p++)
        {
            if(p!=tableKey)
            {
                this.hashTable[p]=new Node(null, null);
            }
        }
        this.hashTable[tableKey]=new Node(key, value);
    }
    private <T,S> Node(T key, S value)
    { 
        entry = new Entry<Key, Value>(key,value);
        next=null;
    }

       
        
        private int hashFunction(Key key)
        {
            return (key.hashCode() & 0x7fffffff) % this.hashTable.length;
        }

        Value get(Key k)
        {
            int index = this.hashFunction(k);
            Node current = this.hashTable[index].head;
            int p=0;
            while(current.next!=null)
            {
                if(current.key==k)
                {
                    return (Value)current.value;
                }
                else if(p==this.hashTable.length)
                {
                    return null;
                }
                p++;
            }
            return null;
        }
        Value put(Key k, Value v)
        {
            int index = this.hashFunction(k);
            Node myLast = this.hashTable[index].head;
            Value old = get(k);
            Node putEntry = new Node<Key,Value>(k,v);
            if(myLast.head==null)
            {
                myLast.head=putEntry;
            }
            else{
                while(myLast.next!=null)
                {
                    myLast=myLast.next;
                }
                myLast.next = putEntry;
            }
            if(old!=null) //get old value if it exists
            {
                return old;
            }
            return null;
        }
}


