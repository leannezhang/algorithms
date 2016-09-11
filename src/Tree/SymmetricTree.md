# Symmetric Tree

> Given a binary tree, check whether it is a mirror of itself(ie, symmetric around its center)

> For example, this tree is symmetric:


```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```
> But the following tree is not.

```
    1
   / \
  2   2
   \   \
   3    3
```

#### Solve it recursively.

- Identify the base case. What is the false case? What's the true case?
- Generic case: Assume that the recursive function works, how can I solve the subset using the recursion method I created?

![Image of Symmetric Tree Recursively]
(https://github.com/leannezhang/algorithms/tree/master/src/Tree/images/SymmetricTree.png)

```java

    public boolean isSymmetric(TreeNode root) {
        if (root != null) {
            return isMirror(root.left, root.right);
        }
        return true;
    }

    public boolean isMirror(TreeNode subtree1, TreeNode subtree2) {
        // base case: true case
        if(subtree1 == null && subtree2 == null) {
            return true;
        }
        // base case: false case
        if (subtree1 !=null && subtree2 == null || subtree2 != null && subtree1 == null) {
            return false;
        }
       // generic case: solve the subcases using the recursive call
       return (subtree1.val == subtree2.val) &&
              (isMirror(subtree1.left, subtree2.right)) &&
              (isMirror(subtree1.right, subtree2.left));
    }
```
Run Time: Since we are visiting every node in the tree, it would be O(n) time.

Space Complexity: Each recursive call is put on to a recursive stack so it's determined by the tree height.
In the worse case, the tree is linear and the height is in O(n). So space complexity is O(n).

#### Solve it iteratively.

We can check if the nodes are symmetrical layer by layer.
When one layer is symmetrical, we can continue look at the next layer.
Thus, the pattern we see is Breadth First Search. (searching layer by layer and using a Queue)
