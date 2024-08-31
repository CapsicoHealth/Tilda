/* ===========================================================================
 * Copyright (C) 2018 CapsicoHealth Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tilda.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author ldh
 *
 */
public class Graph<T>
  {
    protected static final Logger LOG = LogManager.getLogger(Graph.class.getName());

    public static class Node<T>
      {
        public Node(T v)
          {
            _v = v;
          }

        protected T             _v;
        protected List<Node<T>> _children = new ArrayList<Node<T>>();

        public T getValue()
          {
            return _v;
          }

        public List<Node<T>> getChildrenNodes()
          {
            return _children;
          }

        public Node<T> addChild(T v)
          {
            Node<T> n = new Node<T>(v);
            _children.add(n);
            return n;
          }
      }

    public static interface Visitor<T>
      {
        /**
         * 
         * @param level The level, starting at 0 that you are being asked to print.
         * @param FirstMiddleLast 0 if First of level, -1 if middle of level, 1 if last of level.
         * @param v The value of the node
         * @param Path The path of node values 
         * @throws Exception
         */
        void visitNode(int level, int FirstMiddleLast, T v, List<T> Path)
        throws Exception;
      }


    public Graph(T v)
      {
        _Root = new Node<T>(v);
      }

    protected Node<T> _Root;

    public Node<T> getRoot()
      {
        return _Root;
      }
    
    public Set<T> getLeaves(boolean Remove)
      {
        Set<T> Leaves = new HashSet<T>();
        boolean rootWasLeaf = _Root != null && _Root._children.isEmpty() == true;
        getLeaves(Remove, Leaves, _Root);
        if (Remove == true && rootWasLeaf == true)
          _Root = null;
        return Leaves;
      }
    protected void getLeaves(boolean Remove, Set<T> Leaves, Node<T> N)
      {
        if (N == null)
          return;
        if (N._children.isEmpty() == true)
         Leaves.add(N.getValue());  
        else for (int i = 0; i < N._children.size(); ++i)
          {
            Node<T> Child = N._children.get(i);
            boolean wasLeaf = Child._children.isEmpty() == true;
            getLeaves(Remove, Leaves, Child);
            if (Remove == true && wasLeaf == true)
              {
                N._children.remove(i);
                --i;
              }
          }
      }

    public boolean contains(T t)
      {
        return contains(t, _Root);
      }
    protected boolean contains(T t, Node<T> N)
      {
        if (N == null)
          return false;
        if (N._v == t)
         return true;
        else for (int i = 0; i < N._children.size(); ++i)
          {
            Node<T> Child = N._children.get(i);
            if (contains(t, Child) == true)
             return true;
          }
        return false;
      }
    
    public boolean remove(T t)
      {
        return remove(t, _Root);
      }

    protected boolean remove(T t, Node<T> N)
      {
        if (N == null)
          return false;
        boolean found = false;
        for (int i = 0; i < N._children.size(); ++i)
          {
            Node<T> Child = N._children.get(i);
            if (Child._v == t)
              {
                found = true;
                N._children.remove(i);
                --i;
              }
            else if (remove(t, Child) == true)
              found = true;
          }
        return found;
      }
    
    
    protected static <T> void traverse(Visitor<T> V, int Level, int FirstMiddleLast, Node<T> N, List<T> Path, boolean pre)
    throws Exception
      {
        if (N == null)
         return;
        Path.add(N.getValue());
        if (pre == true)
         V.visitNode(Level, FirstMiddleLast, N._v, Path);
        for (int i = 0; i < N.getChildrenNodes().size(); ++i)
          {
            Node<T> Child = N.getChildrenNodes().get(i);
            traverse(V, Level + 1, i == 0 ? 0 : i == N.getChildrenNodes().size() - 1 ? 1 : -1, Child, Path, pre);
          }
        if (pre == false)
          V.visitNode(Level, FirstMiddleLast, N._v, Path);
        Path.remove(Path.size() - 1);
      }

    /**
     * Given a visitor V, traverses the graph depth first 
     * @param V
     * @param pre Whether the visitor should be called on node entry (pre-processing), or node exit (post-processing).
     * @throws Exception
     */
    public void traverse(Visitor<T> V, boolean pre)
    throws Exception
      {
        List<T> Path = new ArrayList<T>();
        traverse(V, 0, 0, _Root, Path, pre);
      }
  }
