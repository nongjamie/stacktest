package ku.util;

import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for StackFactory.
 * @author Sathira Kittisukmongkol
 */
public class StackTest {
	
	private Stack stack;
	
	@Before
	public void setUp() {
		stack = makeStack( 2 );
	}
	
	@Test
	public void testNewStackHasValidCapacity() {
		assertEquals( "Capacity must be 2.", 2 , stack.capacity() );
	}
	
	@Test
	public void testNewStackIsEmpty() {
		assertTrue( stack.isEmpty() );
		assertFalse( stack.isFull() );
		assertEquals( 0 , stack.size() );
	}
	
	@Test ( expected = java.util.EmptyStackException.class )
	public void testPopEmptyStack() {
		Assume.assumeTrue( stack.isEmpty() );
		stack.pop();
	}
	
	@Test 
	public void testNormalPeek() {
		stack.push( "first" );
		stack.push( "second" );
		assertEquals( stack.peek() , "second" );
		assertEquals( stack.peek() , "second" );
	}
	
	@Test
	public void testNormalSize() {
		stack.push( "first" );
		stack.push( "second" );
		assertEquals( 2 , stack.size() );
	}
	
	@Test
	public void testNormalPop() {
		stack.push( 0 );
		stack.push( 1 );
		assertEquals( 1 , stack.pop() );
	}
	
	@Test
	public void testNormalPush() {
		stack.push( 1 );
		assertFalse( stack.isEmpty() );
		assertEquals( 1 , stack.pop() );
	}
	
	@Test
	public void testPeekFullStack() {
		stack.push( 0 );
		stack.push( 1 );
		assertTrue( stack.isFull() );
		assertEquals( 1 , stack.peek() );
		assertEquals( 2 , stack.size() );
	}
	
	@Test
	public void testPopFullStack() {
		stack.push( 0 );
		stack.push( 1 );
		assertTrue( stack.isFull() );
		assertEquals( 1 , stack.pop() );
		assertEquals( 0 , stack.pop() );
		assertFalse( stack.isFull() );
	}
	
	@Test  ( expected = java.lang.IllegalStateException.class )
	public void testOverflow() {
		assertTrue(stack.isEmpty());
		stack.push( 1 );
		stack.push( 2 );
		assertEquals( stack.size() , 2 );
		stack.push( 3 );
		fail( "Cannot push element onto a full stack." );
	}
	
	@Test
	public void testPeekEmptyStack() {
		assertTrue( stack.isEmpty() );
		assertEquals( null , stack.peek() );
	}
	
	@Test
	public void testPushEmptyStack() {
		assertTrue( stack.isEmpty() );
		stack.push( 1 );
		assertEquals( 1 , stack.size() );
	}
	
	@Test ( expected = java.lang.IllegalArgumentException.class )
	public void testPushParameterNull() {
		stack.push( null );
		fail( "Cannot put parameter null." );
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test  ( expected = java.lang.IllegalStateException.class )
	public void testPushFullStack() {
		stack.push( 0 );
		stack.push( 1 );
		assertTrue( stack.isFull() );
		stack.push( 2 );
		fail( "Cannot push item more than capacity." );
	}
	
	private Stack makeStack( int capacity ) {
		return StackFactory.makeStack( capacity );
	}

}
