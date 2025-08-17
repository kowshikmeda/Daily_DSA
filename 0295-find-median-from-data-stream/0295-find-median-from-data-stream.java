class MedianFinder {
    //Left will apply Max heap, bcoz we want large element at the top
    PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>((a,b)->b-a);
     //Right will apply Min heap, bcoz we want small element at the top
    PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>((a,b)->a-b);

    public MedianFinder() {}
    
    public void addNum(int num) {
        //In left heap we will add element only, if it is empty or the element num is smaller than the top element of left
        //Else we will add element in the right heap
        if(leftMaxHeap.isEmpty() || num<leftMaxHeap.peek())leftMaxHeap.add(num);
        else rightMinHeap.add(num);

        //Either both heap should have equal number of values, or
        //Left heap should have only "1" value extra than right heap

        //If dono ke size ka difference 1 se jyaada hai toh, hum left ke top se right main values add krenge
        if(Math.abs(leftMaxHeap.size()-rightMinHeap.size())>1){
            rightMinHeap.add(leftMaxHeap.poll());
        }
        //Humare left main value kam nhi honi chahiye, agar kam hain toh hum right ke top se left main value add krenge
        else if(leftMaxHeap.size()<rightMinHeap.size()){
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        //Agar size even hain toh hum dono ke top ka "mean" nikal ke return krenge
        if(rightMinHeap.size()==leftMaxHeap.size()) {
            double mean = (double)(rightMinHeap.peek()+leftMaxHeap.peek())/2.0;
            return mean;
        }
        //agar size "odd" hai toh hum sirf left ka "TOP" return krenge
        return leftMaxHeap.peek();
    }
}