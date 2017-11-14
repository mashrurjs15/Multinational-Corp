Read Me

Milestone 1
--------------------------------------------------------------------------------------
	- First stage we began brainstorming of project ideas
		- Expand on house pricing
		- Pricing of Computer Rig
		- Stocks Analysis
		- Job Salary Base on Requirements and Skills
		- Neural Networks Recognition of Animals
	- We concluded to do pricing of Computer rig
	- Instead of the whole rig we decided to do just the GPU
	- GPU specifications include: Name, Core Clock, Boost Clock, Memory Size, Company Name, Price
	- This document contains the training examples of our machine learning program. Also includes the equations.
	- The training examples are real life data from GPU sources online
	- For normalizations we set the max to 8GB – Commercial Use
	- To figure out pricing we compare each GPU and derive each feature to determine the benchmark
	- The code has documentation to explain what each things do
	- We did not make a GUI but we made sure it is easy to understand when inputting in the terminal

GPU	Name		Core Clock (GHz)	Boost Clock (GHz)	Memory Size	Company	Price
1	GTX 1060	1.506				1.708				6			Nvidia	299.99
2	GTX 1080	1.607				1.733				8			Nvidia	549.00
3	GTX 1070	1.607				1.683				8			Nvidia	449.00
4	RX 580		1.257				1.340				8			AMD		329.99
5	VEGA 56		1.156				1.471				8			AMD		654.99
6	VEGA 64		1.247				1.546				8			AMD		779.99
7	Test		1.5					1.340				8			Nvidia	???

Commercial Use (8Gb max normalization)

Equations: 
Core Clock/ Boost Clock – Absolute difference for Core Clock, Boost Clock
Z=|x1-x2|

Memory Size – Sum of size divide by sum of number then normalize by dividing whole number by 8
M=  ((∑m_size )/n)/normalize

Company – Discrete Value, 0 if the two values match, 1 otherwise
Machine learning test for pricing

Example/ Using the Training example from above table
Benchmark(G1,G7) ~= 0.006 + 0.368 + 0.636 + 0 = 1.01
Benchmark(G2,G7) ~= 1.5 
Benchmark(G3,G7) ~= 1.45
Benchmark(G4,G7) ~= 2.243
Benchmark(G5,G7) ~= 2.475
Benchmark(G6,G7) ~= 2.459

Thus Test will cost approximately $299.99

Authors + Contribution:
Andrew Nguyen - Project Idea, Data Collection for Training Example, Code, Documentation, ReadMe
Adam Staples - Project Idea, Data Collection for Training Example, Code, Documentation, Reoptimizing
Eric Morrissette - Project Idea , Code, Documentation, UML Diagram, ReadMe
Mohammad Sunny - Project Idea, Data Collection for Training Example, Code, UML Diagram

Roadmap: Planning on improving the machine learning by providing a stronger and more accurate 
algorithm to determine best cost. Next Milestone will iclude GUI.

Milestone 2
-------------------------------------------------------------------------------------

UPDATE:
- System scanner has been replaced with GUI intereaction button and input boxes.
- Implemented the kNN algorithm to predict result for test.
- Made conditions so each parameter will need proper values for it to work.
- Designed a second problem set (the house example).
- UML Updated

- Made two seperate directory (House Problem and GPU Problem). Run them seperately.

