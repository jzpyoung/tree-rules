/**
 * 脚本解析器
 * <p/>
 * <p>脚本举例：
 * [
 *     {
 *         "key": "find",
 *         "root": {
 *             "type": 0,
 *             "element": {
 *                 "op": "WHEN"
 *             },
 *             "left": {
 *                 "type": 1,
 *                 "element": {
 *                     "type": "condition",
 *                     "metaId": "sys:true"
 *                 }
 *             },
 *             "right": {
 *                 "type": 1,
 *                 "element": {
 *                     "type": "action",
 *                     "metaId": "spring:beanName1"
 *                 }
 *             }
 *         }
 *     },
 *     {
 *         "key": "check",
 *         "root": {
 *             "type": 0,
 *             "element": {
 *                 "op": "WHEN"
 *             },
 *             "left": {
 *                 "type": 1,
 *                 "element": {
 *                     "type": "condition",
 *                     "metaId": "sys:true"
 *                 }
 *             },
 *             "right": {
 *                 "type": 1,
 *                 "element": {
 *                     "type": "action",
 *                     "metaId": "spring:beanName2"
 *                 }
 *             }
 *         }
 *     },
 *     {
 *         "key": "deal",
 *         "root": {
 *             "type": 1,
 *             "element": {
 *                 "type": "action",
 *                 "metaId": "spring:beanName3"
 *             }
 *         }
 *     }
 * ]
 * <p/>
 */
package org.jzp.code.tree.rules.parser;