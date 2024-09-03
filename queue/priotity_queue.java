
import java.util.*;
public class priotity_queue 
{
    public class PriorityQeu 
    {
          private Integer []pq;
          private int n;
        
          PriorityQueu(int capacity)
          {
            this.pq = new Integer[capacity+1];
          }

          public void insert(int x)
          {
             this.pq[++n] = x;
             swim(n);
          }

          public Integer delMax()
          {
              int maxEle = this.pq[1];
              swap(1, n--);
              sink(1);

              this.pq[n+1] = null ;// loitering

              return maxEle;
          }

          public boolean isEmpty()
          {
            return this.n == 0;
          }

          public Integer size()
          {
            return this.n;
          }

            private void swim(int k)
            {
                while (k > 1 && pq[k/2] < pq[k])
                 {
                      swap(k, k/2);
                      k = k/2;
                }
            }

        private void sink(int k)
        {
            while (2*k <= n) 
            {
                
                int j = 2*k;
                if (j < n && this.pq[j] < this.pq[j+1]) j++;

                if (this.pq[k] >= this.pq[j]) break;
                
                swap(k, j);
                k = j;
                
            }
        }
            private void swap(int i, int j)
            {
                int temp = this.pq[i];
                this.pq[i] = this.pq[j];
                this.pq[j] = temp;
            }
    }

   public static void main(String[] args) 
   {

       PriorityQeu pq = new PriorityQeu(10);

       pq.insert(5);
       pq.insert(11);
    
    
   }
    
}