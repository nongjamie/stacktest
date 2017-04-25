package ku.util;

import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
	
	private Stack stack;
	
	@Before
	public void setUp() {
		stack = makeStack( 2 );
	}
	
	@Test
	public void newStackIsEmpty() {
		// stack.push("1");
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
	public void testPeek() {
		stack.push("first");
		stack.push("second");
		assertEquals( stack.peek() , "second" );
		assertEquals( stack.peek() , "second" );
	}
	
	@Test
	public void testSize() {
		stack.push("first");
		stack.push("second");
		assertEquals( stack.size() , 2 );
	}
	
	@Test  ( expected = java.lang.IllegalStateException.class )
	public void testOverflow() {
		assertTrue(stack.isEmpty());
		stack.push(1);
		stack.push(2);
		assertEquals( stack.size() , 2 );
		stack.push(3);
		fail( "Cannot push element onto a full stack." );
	}
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	private Stack makeStack( int capacity ) {
		return StackFactory.makeStack( capacity );
	}

}
