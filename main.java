public class Main {
    
    public static void main(String[] args) {

        // TEST #1
        BST<Integer> nums = new BST<>();

        // calling methods
        nums.insert(54);
        nums.insert(18);
        nums.insert(48);
        nums.insert(67);
        nums.insert(112);

        System.out.println(nums.contains(40));
        nums.printInOrder();
    }
}
