package org.apache.jcs.utils.struct;

import java.io.StringWriter;

import junit.framework.TestCase;

import org.apache.jcs.TestLogConfigurationUtil;

/** Unit tests for the double linked list. */
public class DoubleLinkedListUnitTest
    extends TestCase
{
    /** verify that the last is added when the list is empty. */
    public void testAddLast_Empty()
    {
        // SETUP
        DoubleLinkedList list = new DoubleLinkedList();
        
        String payload1 = "payload1";
        DoubleLinkedListNode node1 = new DoubleLinkedListNode( payload1 );       
        
        // WO WORK
        list.addLast( node1 );
               
        // VERIFY
        assertEquals( "Wrong last", node1, list.getLast() );
    }
    
    /** verify that the last is added when the list is empty. */
    public void testAddLast_NotEmpty()
    {
        // SETUP
        DoubleLinkedList list = new DoubleLinkedList();
        
        String payload1 = "payload1";
        DoubleLinkedListNode node1 = new DoubleLinkedListNode( payload1 );       
        
        String payload2 = "payload2";
        DoubleLinkedListNode node2 = new DoubleLinkedListNode( payload2 );
        
        // WO WORK
        list.addLast( node1 );
        list.addLast( node2 );
               
        // VERIFY
        assertEquals( "Wrong last", node2, list.getLast() );
    }
    
    /** verify that it's added last. */
    public void testMakeLast_wasFirst()
    {
        // SETUP
        DoubleLinkedList list = new DoubleLinkedList();
        
        String payload1 = "payload1";
        DoubleLinkedListNode node1 = new DoubleLinkedListNode( payload1 );

        String payload2 = "payload2";
        DoubleLinkedListNode node2 = new DoubleLinkedListNode( payload2 );

        list.addFirst( node2 );
        list.addFirst(  node1 );
        
        // DO WORK
        list.makeLast( node1 );
        
        // VERIFY
        assertEquals( "Wrong size", 2, list.size() );
        assertEquals( "Wrong last", node1, list.getLast() );
        assertEquals( "Wrong first", node2, list.getFirst() );
    }
    
    /** verify that it's added last. */
    public void testMakeLast_wasLast()
    {
        // SETUP
        DoubleLinkedList list = new DoubleLinkedList();
        
        String payload1 = "payload1";
        DoubleLinkedListNode node1 = new DoubleLinkedListNode( payload1 );

        String payload2 = "payload2";
        DoubleLinkedListNode node2 = new DoubleLinkedListNode( payload2 );

        list.addFirst( node1 );
        list.addFirst(  node2 );
        
        // DO WORK
        list.makeLast( node1 );
        
        // VERIFY
        assertEquals( "Wrong size", 2, list.size() );
        assertEquals( "Wrong last", node1, list.getLast() );
        assertEquals( "Wrong first", node2, list.getFirst() );
    }
    
    /** verify that it's added last. */
    public void testMakeLast_wasAlone()
    {
        // SETUP
        DoubleLinkedList list = new DoubleLinkedList();
        
        String payload1 = "payload1";
        DoubleLinkedListNode node1 = new DoubleLinkedListNode( payload1 );

        list.addFirst( node1 );
        
        // DO WORK
        list.makeLast( node1 );
        
        // VERIFY
        assertEquals( "Wrong size", 1, list.size() );
        assertEquals( "Wrong last", node1, list.getLast() );
        assertEquals( "Wrong first", node1, list.getFirst() );
    }
    
    /** verify that it's added last. */
    public void testMakeLast_wasInMiddle()
    {
        // SETUP
        DoubleLinkedList list = new DoubleLinkedList();
        
        String payload1 = "payload1";
        DoubleLinkedListNode node1 = new DoubleLinkedListNode( payload1 );

        String payload2 = "payload2";
        DoubleLinkedListNode node2 = new DoubleLinkedListNode( payload2 );
        
        String payload3 = "payload3";
        DoubleLinkedListNode node3 = new DoubleLinkedListNode( payload3 );        

        list.addFirst( node2 );
        list.addFirst(  node1 );
        list.addFirst(  node3 );
        
        // DO WORK
        list.makeLast( node1 );
        
        // VERIFY
        assertEquals( "Wrong size", 3, list.size() );
        assertEquals( "Wrong last", node1, list.getLast() );
        assertEquals( "Wrong first", node3, list.getFirst() );
    }
    
    /** verify that the entries are dumped. */
    public void testDumpEntries_DebugTrue()
    {
        // SETUP
        StringWriter stringWriter = new StringWriter();
        TestLogConfigurationUtil.configureLogger( stringWriter, DoubleLinkedList.class.getName() );
        
        DoubleLinkedList list = new DoubleLinkedList();
        
        String payload1 = "payload1";
        DoubleLinkedListNode node1 = new DoubleLinkedListNode( payload1 );       
        
        String payload2 = "payload2";
        DoubleLinkedListNode node2 = new DoubleLinkedListNode( payload2 );
        
        list.addLast( node1 );
        list.addLast( node2 );
        list.debugDumpEntries();
        
        // WO WORK
        String result = stringWriter.toString();
               
        // VERIFY
        assertTrue( "Missing node in log dump", result.indexOf( payload1 ) != -1 );
        assertTrue( "Missing node in log dump", result.indexOf( payload2 ) != -1 );
    }
}
