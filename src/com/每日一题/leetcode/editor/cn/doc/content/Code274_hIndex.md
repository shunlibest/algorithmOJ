<p>给你一个整数数组 <code>citations</code> ，其中 <code>citations[i]</code> 表示研究者的第 <code>i</code> 篇论文被引用的次数。计算并返回该研究者的 <strong><code>h</code><em>&nbsp;</em>指数</strong>。</p>

<p>根据维基百科上&nbsp;<a href="https://baike.baidu.com/item/h-index/3991452?fr=aladdin" target="_blank">h 指数的定义</a>：<code>h</code> 代表“高引用次数” ，一名科研人员的 <code>h</code><strong> 指数 </strong>是指他（她）至少发表了 <code>h</code> 篇论文，并且&nbsp;<strong>至少&nbsp;</strong>有 <code>h</code> 篇论文被引用次数大于等于 <code>h</code> 。如果 <code>h</code><em> </em>有多种可能的值，<strong><code>h</code> 指数 </strong>是其中最大的那个。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong><span><code>citations = [3,0,6,1,5]</code></span>
<strong>输出：</strong>3 
<strong>解释：</strong>给定数组表示研究者总共有 <span><code>5</code></span> 篇论文，每篇论文相应的被引用了 <span><code>3, 0, 6, 1, 5</code></span> 次。
&nbsp;    由于研究者有 <span><code>3 </code></span>篇论文每篇 <strong>至少 </strong>被引用了 <span><code>3</code></span> 次，其余两篇论文每篇被引用 <strong>不多于</strong> <span><code>3</code></span> 次，所以她的 <em>h </em>指数是 <span><code>3</code></span>。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>citations = [1,3,1]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == citations.length</code></li> 
 <li><code>1 &lt;= n &lt;= 5000</code></li> 
 <li><code>0 &lt;= citations[i] &lt;= 1000</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>计数排序</li><li>排序</li></div></div><br><div><li>👍 520</li><li>👎 0</li></div>