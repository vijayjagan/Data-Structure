package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class StockSpanner {

  List<Integer> stockList;


  public StockSpanner() {
    this.stockList = new ArrayList<>();
  }

  public int next(int price) {
    int count = 1;
    if (stockList.isEmpty()) {
      stockList.add(price);
      return count;
    }
    stockList.add(price);
    int n = stockList.size() - 1;
    for (int i = n; i > -1; i--) {
      if (i - 1 > -1 && stockList.get(i) <= price) {
        count++;
      } else {
        break;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    StockSpanner stockSpanner = new StockSpanner();
    System.out.println(stockSpanner.next(31));
    System.out.println(stockSpanner.next(41));
    System.out.println(stockSpanner.next(48));
    System.out.println(stockSpanner.next(59));
    System.out.println(stockSpanner.next(79));
  }


}
