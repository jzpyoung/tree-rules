/**
 * 当前的引擎中元素以一种二叉树的方式进行排列，组成一种简单的语法树
 * <p/>
 * <p>语法规则如下：
 * <li>元素分为运算元素-OperatorElement(类似于操作符)，和执行元素-(类似于操作数)
 * <li>根节点只能是WHEN。
 * <li>如果一个节点是WHEN，那么它的左子节点必须是Condition、AND或者OR，
 * 右子节点必须是Action。
 * <li>如果一个节点是AND或者OR，那么它的(左右)子节点必须是Condition、AND或者OR
 * <li>如果一个节点时Action，那么它的子节点必须是WHEN
 * <p/>
 * <p/>
 * <pre> W=WHEN C=Condition A=Action
 * -------------W
 * ----------／----＼
 * ---------C--------A
 *
 * -------------W
 * ----------／----＼
 * --------AND-------A
 * -------／-＼
 * ------C1---C2
 *
 * -------------W
 * ----------／----＼
 * --------AND------A1
 * -------／--＼-------＼
 * ------C1--- C2-------W
 * -------------------／--＼
 * ------------------C3----A2
 * </pre>
 *
 * @see org.jzp.code.tree.rules.element.OperatorElement
 * @see org.jzp.code.tree.rules.element.Action
 * @see org.jzp.code.tree.rules.element.Condition
 */
package org.jzp.code.tree.rules.element;