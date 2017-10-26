// By Mark Mandel <mark.mandel@gmail.com>

use std::cmp;
use std::ops::Deref;

//Immutable Binary Search Tree. All operations return a brand new BST.
#[derive(Debug, PartialEq, Eq, Clone)]
pub enum BST<T> {
    Leaf(T),
    // value, left ,       right
    Branch(T, Box<BST<T>>, Box<BST<T>>),
    Nil,
}

impl<T: PartialOrd + Ord> cmp::PartialOrd for BST<T> {
    fn partial_cmp(&self, other: &Self) -> Option<cmp::Ordering> {
            Some(self.cmp(other))
    }
}

impl<T: Ord> cmp::Ord for BST<T> {
    fn cmp(&self, other: &Self) -> cmp::Ordering {
        match self {
            &BST::Nil => {
                match other {
                    &BST::Nil => cmp::Ordering::Equal,
                    _ => cmp::Ordering::Less
                }
            }
            &BST::Leaf(ref lhs) | &BST::Branch(ref lhs, _, _) => {
                match other {
                    &BST::Nil => cmp::Ordering::Greater,
                    &BST::Leaf(ref rhs) | &BST::Branch(ref rhs, _, _) => lhs.cmp(rhs)
                }
            }
        }
    }
}


impl<T: Ord + Clone> BST<T> {

    //new, empty BST
    pub fn new() -> BST<T> {
        BST::Nil
    }

    //push a value in
    pub fn push(self, v: T) -> BST<T> {
        self.push_node(&BST::Leaf(v))
    }

    //TODO: Make BST<T> comparable, and see if that fixes some ownership issues.
    //insert a whole BST enum type
    fn push_node(self, node: &BST<T>) -> BST<T> {
        match self {
            BST::Nil => node.clone(),
            BST::Branch(value, left, right) => {
                match node {
                    &BST::Nil => BST::Nil,
                    &BST::Leaf(ref new_value) | &BST::Branch(ref new_value, _, _) => {
                        match new_value.cmp(&value) {
                            cmp::Ordering::Less => BST::Branch(value, Box::new(left.push_node(node)), right),
                            _ => BST::Branch(value, left, Box::new(right.push_node(node))),
                        }
                    },
                }
            },
            BST::Leaf(value) => {
                match node {
                    &BST::Nil => BST::Nil,
                    &BST::Leaf(ref new_value) | &BST::Branch(ref new_value, _, _) => {
                        match new_value.cmp(&value) {
                            cmp::Ordering::Less => BST::Branch(value, Box::new(node.clone()), Box::new(BST::Nil)),
                            _ => BST::Branch(value, Box::new(BST::Nil), Box::new(node.clone())),
                            }
                    },
                }
            },
        }
    }

    //returns the value that is Ordering::Equal to v.
    pub fn get(&self, v: &T) -> Option<T> {
        match self {
            &BST::Leaf(ref value) if value == v => Some(value.clone()),
            &BST::Branch(ref value, ref left, ref right) => {
                match v.cmp(value) {
                    cmp::Ordering::Equal => Some(value.clone()),
                    cmp::Ordering::Less => left.get(v),
                    cmp::Ordering::Greater => right.get(v),
                }
            },
            _ => None,
        }
    }

    //Gets the minimum value
    pub fn min(&self) -> Option<T> {
        match self {
            &BST::Nil => None,
            &BST::Leaf(ref value) => Some(value.clone()),
            &BST::Branch(ref value, ref left, _) if left.deref() == &BST::Nil => Some(value.clone()),
            &BST::Branch(_, ref left, _) => left.min(),
        }
    }

    //Gets the minimum value
    pub fn max(&self) -> Option<T> {
        match self {
                &BST::Nil => None,
                &BST::Leaf(ref value) => Some(value.clone()),
                &BST::Branch(ref value, _, ref right) if right.deref() == &BST::Nil => Some(value.clone()),
                &BST::Branch(_, _, ref right) => right.max(),
            }
    }

    pub fn delete(self, v: T) -> BST<T> {
        match self {
            BST::Nil => self,
            BST::Leaf(ref value) => {
                match v.cmp(value) {
                    cmp::Ordering::Equal => BST::Nil,
                    _ => self.clone()
                }
            },
            BST::Branch(value, left, right) => {
                match v.cmp(&value) {
                    cmp::Ordering::Equal => {
                        if *left != BST::Nil && *right == BST::Nil {
                            //if I only have a left value, replace me
                            *left
                        } else if *left == BST::Nil && *right != BST::Nil {
                            //if I only have a right value, replace me
                            *right
                        } else {
                            //if i have 2 values, grab the left most value of the right branch
                            let replacement = match right.min() {
                                None => unreachable!(),
                                Some(value) => value,
                            };

                            let right = right.delete(replacement.clone());

                            BST::Branch(replacement, left, Box::new(right))
                        }
                    },
                    cmp::Ordering::Less => BST::Branch(value, Box::new(left.delete(v)), right).downgrade(),
                    cmp::Ordering::Greater => BST::Branch(value, left, Box::new(right.delete(v))).downgrade(),
                }
            },
        }
    }

    //if I'm a branch with no leaves, then return me as a leaf, otherwise I'll return myself
    fn downgrade(self) -> BST<T> {
        match self {
            BST::Branch(ref value, ref left, ref right) if **left == BST::Nil && **right == BST::Nil => BST::Leaf(value.clone()),
            _ => self
        }
    }
}

#[cfg(test)]
mod test {
    use super::{BST};
    use std::cmp;

    fn single_value_fixture() -> BST<i32> {
        BST::Leaf(32)
    }

    #[test]
    fn test_creation() {
        let t = single_value_fixture();
        assert_eq!(BST::Leaf(32), t);
    }

    #[test]
    fn test_insertion_no_root() {
        let t = BST::new();

        let node = BST::Leaf(43);
        let expected = node.clone();

        let t = t.push_node(&node);

        assert_eq!(t, expected)
    }

    #[test]
    fn test_insertion_single_left_leaf() {

        let t = single_value_fixture();
        let node = BST::Leaf(15);

        let expected = BST::Branch(32, Box::new(node.clone()), Box::new(BST::Nil));

        let t = t.push_node(&node);

        assert_eq!(t, expected);
    }

    #[test]
    fn test_insertion_single_right_leaf() {

        let t = single_value_fixture();
        let node = BST::Leaf(45);

        let expected = BST::Branch(32, Box::new(BST::Nil), Box::new(node.clone()));

        let t = t.push_node(&node);

        assert_eq!(t, expected);
    }

    #[test]
    fn test_complicated_value_bst() {
        let t: BST<i32> = BST::new()
            .push(10)
            .push(5)
            .push(3)
            .push(15)
            .push(12)
            .push(14);

        //lazy assertion, because it's easier to type
        assert_eq!("Branch(10, Branch(5, Leaf(3), Nil), Branch(15, Branch(12, Nil, Leaf(14)), Nil))", format!("{:?}", t))
    }

    #[test]
    fn test_getting_values() {
        let t: BST<i32> = BST::new()
        .push(10)
        .push(5)
        .push(3)
        .push(15)
        .push(12)
        .push(14);

        //not there
        let result = t.get(&27);
        assert_eq!(None, result);

        let result = t.get(&10);
        assert_eq!(Some(10), result);

        let result = t.get(&5);
        assert_eq!(Some(5), result);

        let result = t.get(&12);
        assert_eq!(Some(12), result);

        let result = t.get(&14);
        assert_eq!(Some(14), result);
    }

    #[test]
    fn test_min_max() {
        let t: BST<i32> = BST::new()
        .push(10)
        .push(5)
        .push(3)
        .push(15)
        .push(12)
        .push(14);

        assert_eq!(Some(3), t.min());
        assert_eq!(Some(15), t.max());
    }

    #[test]
    fn test_delete_left() {
        let t: BST<i32> = BST::new()
        .push(10)
        .push(5)
        .push(3)
        .delete(3);

        let expected: BST<i32> = BST::new()
        .push(10).push(5);

        assert_eq!(t, expected);

        let t: BST<i32> = BST::new()
        .push(10)
        .push(5)
        .push(3)
        .delete(5);

        let expected: BST<i32> = BST::new()
        .push(10).push(3);

        assert_eq!(t, expected);
    }

    #[test]
    fn test_delete_right() {
        let t: BST<i32> = BST::new()
        .push(10)
        .push(20)
        .push(30)
        .delete(30);

        let expected: BST<i32> = BST::new()
        .push(10).push(20);

        assert_eq!(t, expected);

        let t: BST<i32> = BST::new()
        .push(10)
        .push(20)
        .push(30)
        .delete(20);

        let expected: BST<i32> = BST::new()
        .push(10).push(30);

        assert_eq!(t, expected);
    }

    #[test]
    fn test_delete_branch_single_right_value() {
        let t: BST<i32> = BST::new()
        .push(10)
        .push(20)
        .push(30)
        .push(15)
        .push(25)
        .push(22)
        .push(35);

        println!("\nBefore:\t\t{:?}", t);

        let t = t.delete(30);

        println!("After:\t\t{:?}", t);

        let expected: BST<i32> = BST::new()
        .push(10)
        .push(20)
        .push(15)
        .push(35)
        .push(25)
        .push(22);

        println!("Expected:\t{:?}", expected);


        assert_eq!(t, expected);
    }

    #[test]
    fn test_delete_branch_multiple_right_values() {
        let t: BST<i32> = BST::new()
        .push(10)
        .push(20)
        .push(30)
        .push(15)
        .push(25)
        .push(22)
        .push(35);

        println!("\nBefore:\t\t{:?}", t);

        let t = t.delete(20);

        println!("After:\t\t{:?}", t);

        let expected: BST<i32> = BST::new()
        .push(10)
        .push(22)
        .push(15)
        .push(30)
        .push(25)
        .push(35);

        println!("Expected:\t{:?}", expected);

        assert_eq!(t, expected);
    }

    #[test]
    fn test_bst_ord() {
        let a: BST<i32> = BST::Nil;
        let b: BST<i32> = BST::Nil;

        assert_eq!(a.cmp(&b), cmp::Ordering::Equal);

        let a: BST<i32> = BST::Leaf(3);

        assert_eq!(a.cmp(&b), cmp::Ordering::Greater);
        assert_eq!(b.cmp(&a), cmp::Ordering::Less);

        let a: BST<i32> = BST::Branch(3, Box::new(BST::Nil), Box::new(BST::Nil));

        assert_eq!(a.cmp(&b), cmp::Ordering::Greater);
        assert_eq!(b.cmp(&a), cmp::Ordering::Less);

        let b: BST<i32> = BST::Branch(3, Box::new(BST::Nil), Box::new(BST::Nil));
        assert_eq!(a.cmp(&b), cmp::Ordering::Equal);

        let b: BST<i32> = BST::Branch(1, Box::new(BST::Nil), Box::new(BST::Nil));

        assert_eq!(a.cmp(&b), cmp::Ordering::Greater);
        assert_eq!(b.cmp(&a), cmp::Ordering::Less);

        let a: BST<i32> = BST::Leaf(3);

        let b: BST<i32> = BST::Branch(3, Box::new(BST::Nil), Box::new(BST::Nil));
        assert_eq!(a.cmp(&b), cmp::Ordering::Equal);

        let b: BST<i32> = BST::Branch(1, Box::new(BST::Nil), Box::new(BST::Nil));

        assert_eq!(a.cmp(&b), cmp::Ordering::Greater);
        assert_eq!(b.cmp(&a), cmp::Ordering::Less);
    }

    #[test]
    fn test_partial_ord() {
        let a: BST<i32> = BST::Nil;
        let b: BST<i32> = BST::Nil;

        assert_eq!(a.partial_cmp(&b), Some(cmp::Ordering::Equal));

        let a: BST<i32> = BST::Leaf(3);

        assert_eq!(a.partial_cmp(&b), Some(cmp::Ordering::Greater));
        assert_eq!(b.partial_cmp(&a), Some(cmp::Ordering::Less));

        let a: BST<i32> = BST::Branch(3, Box::new(BST::Nil), Box::new(BST::Nil));

        assert_eq!(a.partial_cmp(&b), Some(cmp::Ordering::Greater));
        assert_eq!(b.partial_cmp(&a), Some(cmp::Ordering::Less));

        let b: BST<i32> = BST::Branch(3, Box::new(BST::Nil), Box::new(BST::Nil));
        assert_eq!(a.partial_cmp(&b), Some(cmp::Ordering::Equal));

        let b: BST<i32> = BST::Branch(1, Box::new(BST::Nil), Box::new(BST::Nil));

        assert_eq!(a.partial_cmp(&b), Some(cmp::Ordering::Greater));
        assert_eq!(b.partial_cmp(&a), Some(cmp::Ordering::Less));

        let a: BST<i32> = BST::Leaf(3);

        let b: BST<i32> = BST::Branch(3, Box::new(BST::Nil), Box::new(BST::Nil));
        assert_eq!(a.partial_cmp(&b), Some(cmp::Ordering::Equal));

        let b: BST<i32> = BST::Branch(1, Box::new(BST::Nil), Box::new(BST::Nil));

        assert_eq!(a.partial_cmp(&b), Some(cmp::Ordering::Greater));
        assert_eq!(b.partial_cmp(&a), Some(cmp::Ordering::Less));
    }
}
