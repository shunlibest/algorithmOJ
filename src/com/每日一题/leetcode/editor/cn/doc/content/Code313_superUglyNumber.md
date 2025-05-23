<p><strong>超级丑数</strong> 是一个正整数，并满足其所有质因数都出现在质数数组 <code>primes</code> 中。</p>

<p>给你一个整数 <code>n</code> 和一个整数数组 <code>primes</code> ，返回第 <code>n</code> 个 <strong>超级丑数</strong> 。</p>

<p>题目数据保证第 <code>n</code> 个 <strong>超级丑数</strong> 在 <strong>32-bit</strong> 带符号整数范围内。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 12, <span><code>primes</code></span> = <span><code>[2,7,13,19]</code></span>
<strong>输出：</strong>32 
<strong>解释：</strong>给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1, primes = [2,3,5]
<strong>输出：</strong>1
<strong>解释：</strong>1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
</pre>

&nbsp;

<div class="top-view__1vxA"> 
 <div class="original__bRMd"> 
  <div> 
   <p><strong>提示：</strong></p> 
  </div>
 </div>
</div>

<ul> 
 <li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= primes.length &lt;= 100</code></li> 
 <li><code>2 &lt;= primes[i] &lt;= 1000</code></li> 
 <li>题目数据<strong> 保证</strong> <code>primes[i]</code> 是一个质数</li> 
 <li><code>primes</code> 中的所有值都 <strong>互不相同</strong> ，且按 <strong>递增顺序</strong> 排列</li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 425</li><li>👎 0</li></div>