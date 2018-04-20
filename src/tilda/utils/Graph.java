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
import java.util.List;

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
         * @param v
         */
        void visitNode(int level, int FirstMiddleLast, T v, List<T> Path) throws Exception;
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

    protected static <T> void Traverse(Visitor<T> V, int Level, int FirstMiddleLast, Node<T> N, List<T> Path) throws Exception
      {
        Path.add(N.getValue());
        V.visitNode(Level, FirstMiddleLast, N._v, Path);
        for (int i = 0; i < N.getChildrenNodes().size(); ++i)
          {
            Node<T> Child = N.getChildrenNodes().get(i);
            FirstMiddleLast = i == 0 ? 0 : i == N.getChildrenNodes().size()-1 ? 1 : -1;
            Traverse(V, Level+1, FirstMiddleLast, Child, Path);
          }
        Path.remove(Path.size()-1);
      }

    public void Traverse(Visitor<T> V) throws Exception
      {
        List<T> Path = new ArrayList<T>();
        Traverse(V, 0, 0, _Root, Path);
      }
  }
