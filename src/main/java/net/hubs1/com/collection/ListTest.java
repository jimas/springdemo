package net.hubs1.com.collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    

    public static void main(String[] args) {
        List list=new ArrayList();
        for(int i=0;i<50;i++){
            list.add(i);
        }
        int number=8;
        int y=0;
        while(true){
            int fromIndex=number*y;
            int toIndex=number*(++y)>list.size()?list.size():number*(y);
            List subList = list.subList(fromIndex, toIndex);
            System.out.println(subList);
            if(toIndex>=list.size()){
                break;
            }
        }
        
    }

}
