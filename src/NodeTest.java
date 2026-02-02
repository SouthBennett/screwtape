import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

  // -------- WAVE 1 -------

  @Test
  void testListConstructorWithThreeValues() {
    // Arrange
    List<Integer> values = List.of(5, 7, 3);

    // Act
    Node head = new Node(values);

    // Assert
    assertEquals(5, head.value);
    assertNotNull(head.next);
    assertEquals(7, head.next.value);
    assertNotNull(head.next.next);
    assertEquals(3, head.next.next.value);
    assertNull(head.next.next.next);
    assertEquals(head, head.next.prev);
    assertEquals(head.next, head.next.next.prev);
  }

  @Test
  void testListConstructorWithEmptyList() {
    // Arrange
    List<Integer> emptyList = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Node(emptyList),
        "Expected constructor to throw IllegalArgumentException for an empty list."
    );
  }

  // TODO: Add test for list constructor when passed null list
  @Test
  void testListConstructorWithNullList() {
    // No arrange because there is no test data. null is passed directly to the constructor

    //act and assert
    assertThrows(
      IllegalArgumentException.class,
      () -> new Node((List<Integer>) null),
      "Expected constructor to throw IllegalArgumentException for a null list."
    );
  }

  // TODO: Add at least one more test for list constructor that would be useful and cover new ground.
  @Test
  void testListConstructorWithSingleValue() {
    // arrange
    List<Integer> singleValue = List.of(23);

    // act
    Node head = new Node(singleValue);

    // assert 
    assertEquals(23, head.value);
    assertEquals(null, head.next); // if there is only a single node then head.next should be null
    assertEquals(null, head.prev); // if there is only a single node then head.prev should be null
  }


  // -------- WAVE 2 -------

  @Test
  void testToListWithThreeValues() {
    // Arrange
    Node head = new Node(5);
    Node middle = new Node(7);
    Node tail = new Node(3);

    head.next = middle;
    middle.prev = head;
    middle.next = tail;
    tail.prev = middle;

    // Act
    List<Integer> values = head.toList();

    // Assert
    assertEquals(List.of(5, 7, 3), values);
  }

  // TODO: Add test for Node with no next or prev
  // TODO: Add at least one more test for list constructor that would be useful and cover new ground.
}
