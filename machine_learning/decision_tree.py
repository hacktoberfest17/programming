import numpy as np;
import pandas as pd
import argparse
from math import *
from copy import deepcopy

def loadData(fileName):
	df = pd.read_csv(fileName)
	print("Count: " + str(df.shape));

	train = df.head(int(df.shape[0] * 0.8))
	test = df.tail(int(df.shape[0] * 0.2))
	print("Train set: " + str(train.shape) + " Test set: " + str(test.shape))
	return train, test

def entropy_function(value, total):
	if ( value == 0 ) :
		return 0
	ent = -value/total * log ( value/total ,2)
	# print  ("Entropy " + str ( ent))
	return ent*1.0

def disorder(subset) :
	T=len(subset)
	P=len(subset[subset.left == 1])
	N=len(subset[subset.left == 0])
	# print  ("T, P, N " + str ( [T,P,N]))
	ent= entropy_function (P,T)  + entropy_function(N,T)

	return ent;

def analyzeDataForDirectValue(train, feature):
	entropy=0
	conditionset=[]

	for param in  pd.unique(train[feature]):
		decision= feature + ' == ' + "'" + str(param) + "'"
		# print ( "Condition: " + decision);
		subset=train.query(decision);

		T=len(subset)
		if ( T == 0 ):
			continue
		ent=disorder(subset)
		entropy += ent;
		conditionset.append(decision)
	# print ( "Entropy : " + str(entropy) + " Conditions: " + str(conditionset))
	return entropy, conditionset;
def analyzeDataForRange(train, feature):
# 'satisfaction_level', 'last_evaluation', 'number_project',
# 'average_montly_hours', 'time_spend_company', 'Work_accident', 'left',
# 'promotion_last_5years', 'sales', 'salary'
	split=1.0/2;
	satl=np.arange(split * max(train[feature]), (1 + (split)) * max(train[feature]), split * max(train[feature]))
	# print ( "Satisfaction levels:" )
	# print ( satl);
	prev=0
	entropies=[]
	entropy=0
	conditionset=[]
	for level in satl:
		decision=str(prev) + ' < ' + feature + ' <= ' + str(level);
		# print ( "Subset condition :" + decision);

		subset=train.query(decision);
		T=len(subset)
		if ( T == 0 ):
			continue

		ent=disorder(subset)
		prev=level
		entropy += ent;
		conditionset.append(decision)
	return entropy, conditionset

def findentropy(data):
	for feature in ['satisfaction_level','last_evaluation', 'number_project', 'average_montly_hours','time_spend_company','Work_accident','promotion_last_5years']:
		rows=len(pd.unique(train[feature]));
		if ( rows == 0 ):
			continue
		if ( rows > 10 ):
			entropy, conditionset = analyzeDataForRange(train, feature);
			feature_entropies.append([feature,entropy])
			feature_conditions[feature] = conditionset
		else:
			entropy, conditionset = analyzeDataForDirectValue(train, feature)
			feature_entropies.append([feature,entropy])
			feature_conditions[feature] = conditionset

	for feature in ['Departments', 'salary']:
		rows=len(pd.unique(train[feature]));
		if ( rows == 0 ):
			continue
		entropy, conditionset = analyzeDataForDirectValue(train, feature)
		feature_entropies.append([feature,entropy])
		feature_conditions[feature] = conditionset

	fe = pd.DataFrame(feature_entropies, columns=['feature', 'entropy']).sort_values('entropy', inplace=True)
	return fe, conditionset

class DecisionTree :
	# def __init__():
		# self.allfeatures=[]
	# def split(train):
	# def findentropy(data):
		# for feature in ['satisfaction_level','last_evaluation', 'number_project', 'average_montly_hours','time_spend_company','Work_accident','promotion_last_5years']:
	def get_direct_value_features (self, train, feature):
		conditionset=[]
		for param in  pd.unique(train[feature]):
			decision = ""
			if ( train[feature].dtype == np.int64 or train[feature].dtype == np.float64 or train[feature].dtype == np.int32 or train[feature].dtype == np.float32 ):
				decision= feature + ' == ' + str(param)
			else:
				decision= feature + ' == ' + "'" + str(param) + "'"
			# print ( "Condition: " + decision);
			subset=train.query(decision);
			T=len(subset)
			if ( T == 0 ):
				continue
			conditionset.append(decision)
		return conditionset;

	def get_range_features(self, train, feature):

		split=1.0/20;
		valuerange=np.arange(split * max(train[feature]), (1 + (split)) * max(train[feature]), split * max(train[feature]))

		prev=0
		conditionset=[]
		for level in valuerange:
			decision=str(prev) + ' < ' + feature + ' <= ' + str(level);
			# print ( "Subset condition :" + decision);
			subset=train.query(decision);
			T=len(subset)
			if ( T == 0 ):
				continue
			prev=level
			conditionset.append(decision)
		return conditionset

	def get_entropy(self, data, feature_conditions):
		feature_entropies = []
		for feature in feature_conditions:
			# print(self.feature_conditions[feature]);
			entropy=0
			for decision in feature_conditions[feature]:
			# print ( "Condition: " + decision);
				subset=train.query(decision);
				T=len(subset)
				if ( T == 0 ):
					continue
				ent=disorder(subset)
				entropy += ent;
			feature_entropies.append([feature, entropy])
			# print ( "Entropy : " + str(entropy) + " Conditions: " + str(feature_conditions[feature]))
		fe = pd.DataFrame(feature_entropies, columns=['feature', 'entropy']).sort_values('entropy')
		return fe;

	def prepare_data(self,data):
		feature_conditions = {}
		#features = ['satisfaction_level','last_evaluation']
		features = ['satisfaction_level','last_evaluation', 'number_project', 'average_montly_hours','time_spend_company','Work_accident','promotion_last_5years']
		for feature in features:
			rows=len(pd.unique(train[feature]));
			if ( rows == 0 ):
				continue
			if ( rows > 10 ):
				conditionset = self.get_range_features(train, feature);
				feature_conditions[feature] = conditionset
			else:
				conditionset = self.get_direct_value_features(train, feature)
				feature_conditions[feature] = conditionset
		# for feature in ['Departments', 'salary']:
			# rows=len(pd.unique(train[feature]));
			# if ( rows == 0 ):
				# continue
			# conditionset = self.get_direct_value_features(train, feature)
			# feature_conditions[feature] = conditionset
		return feature_conditions
	def create_node(self):
		node = {}
		node['class'] = -1
		node['leaf'] = False
		node['next'] = {}
		return node

	def make_splits(self, data, feature_conditions, level=1, maxlevel=10):
		entropies = self.get_entropy( data, feature_conditions)
		splits=[]
		# print("Entropy: " + str(entropies));
		# print("Features: " + str(len(feature_conditions.keys())))

		# print ( "make_splits - Rows in set" + str(len(data)));
		if ( level > maxlevel ):
			print ( "Maximum level exceeded: " + str(level) + "Rows: " + str(len(data)))
			return splits
		nConditions = 0
		# print ( "make_splits - Rows in set: " + str(len(data)) );
		nClassified=0
		feature = ""
		## This is wierd way of getting the top row with least entropy.
		for f in entropies['feature']:
			feature = f
			break;
		# print ( "Feature: " + feature );

		conditions = deepcopy(feature_conditions[feature])
		next_conditions=deepcopy(feature_conditions)
		next_conditions.pop(feature)

		for decision in conditions :
			node = self.create_node()
			subset = data.query(decision)
			# print ( "decision: " + decision + " Rows length: " + str(len(subset)))
			if ( len(subset) > 0 ):
				node['decision'] = decision;
				node['level'] = level
				T=len(subset)
				P=len(subset[subset.left == 1])
				N=len(subset[subset.left == 0])
				# print ( "Total: " + str(T) + " Positives: " + str(P) + " Negatives: " + str(N))
				if  T == P  :
					node['class'] = 1
					node['leaf'] = True
					nClassified += T;
					subset = subset[subset.left == 1]
					# print("Classified : " + str(T) + " decision: " + decision);
				elif T == N :
					node['class'] = 0
					node['leaf'] = True
					nClassified += T;
					subset = subset[subset.left == 0]
					# print("Classified : " + str(T) + " decision: " + decision);
					#Perfectly classifies
				else:
					# Does not perfectly qualify.
					if  (len (next_conditions) == 0) :
						self.nImpureLeafs += len(subset)
					# print("   No homoginity for :[" + decision + " ] Next: " + str(next_conditions.keys()) + "Data set size:" + str(len(subset)))
					#This is recursion. I want to be very sure of single iteration before I uncomment this line.
					if  ( len (next_conditions) == 0 ):
						self.nImpureLeafs += len(subset)
						node['leaf'] = True
						node['class'] = 1 if (P/T > N/T) else 0
					else :
						node['leaf'] = False
						node['splits'] = self.make_splits(subset, next_conditions, level +1)
				splits.append(node)
		self.nClassified += nClassified;
		# for debugnode in splits:
			# if debugnode['leaf'] :
				# print ( "Classified: " + str(debugnode['class']) + " decision: " + debugnode['decision'] + " Total classified so far: " + str(nClassified))
			# else:
				# print ( "No clssification: " + debugnode['decision'])
		return splits;
	def check_decision(self, sample, decision):
		reduced=sample.query(decision)
		# print  ( "Reduced: " + str(reduced))

		res = len(reduced) > 0
		return res
	def predict(self, node, sample, depth=1) :
		""" sample is a DataFrame """
		""" Tree organised in the following way"""
		"""
			rootnode
				splits [node1,node2,.....]
						  |
						splits [node1,node2,.....]
							....
							....

		"""

		for split in node:
			# print ( "Decision: " + split['decision'] + " Sample: " + str(sample));
			if self.check_decision(sample, split['decision']):

				if ( split['leaf'] ):
					return split['class'], depth
				else :
					return self.predict ( split['splits'], sample, depth + 1)
		return -1,depth
	def build_tree(self, train):
		self.nClassified=0
		self.nImpureLeafs = 0
		self.feature_conditions = dt.prepare_data(train)

		# print ( self.feature_conditions)
		self.rootlevel = self.make_splits(data=train, feature_conditions=self.feature_conditions);
		# print("Total rows: " + str(len(train)) + "  Classified: " + str(self.nClassified) + " Not classified: " + str(self.nImpureLeafs));
	def reset_metrics(self):
		self.tp=0
		self.tn=0
		self.fp=0
		self.fn=0
	def add_to_metrics(self, actual,predicted):
		if ( actual == 1 and predicted == 1 ):
			self.tp += 1;
		if ( actual == 1 and predicted == 0 ):
			self.fn += 1
		if ( actual == 0 and predicted == 0 ):
			self.tn += 1;
		if ( actual == 0 and predicted == 1 ):
			self.fp += 1

	def final_metrics(self):
		precision = 0 if (self.tp + self.fp) == 0 else self.tp / (self.tp + self.fp)
		recall = 0 if ( self.tp + self.fn) == 0 else self.tp / ( self.tp + self.fn)
		accuracy = (self.tp + self.tn) / ( self.tp + self.tn + self.fp + self.fn)
		return {'precision':precision, 'recall': recall, 'accuracy': accuracy}
	def testprediction(self, test) :
		self.reset_metrics();
		ni=0;

		for sample in test.values:
			# print ( "****** Test Sample:" + str(sample))
			# print ( "********")

			df = pd.DataFrame(columns=test.columns);
			df.loc[0] =  sample
			# print (df.loc[0]['satisfaction_level']);
			left,depth = dt.predict(dt.rootlevel,df)
			self.add_to_metrics(df.loc[0]['left'], left);
			# print ( "Predicted Class: " + str(left) + " Depth: " + str(depth) + " Actual class: " + str(df.loc[0]['left']));
			# print("[" + str(ni) + "] ", end='', flush=True)
			ni+=1
		print ("");
		print ( "Metrics: " + str(self.final_metrics()))


if __name__ == '__main__':
	#print("Do something")

	parser = argparse.ArgumentParser(description='Decision tree')
	parser.add_argument("trainfile", metavar="trainingdatafile", help="training file" );
	args=parser.parse_args()
	train, test = loadData(args.trainfile)
	# print ( train.columns);
	# print ( train.query("Departments == 'sales'"))
	feature_entropies = []
	feature_conditions = {}
	# print ( str(test['left'].dtype))


	dt=DecisionTree()
	dt.build_tree(train);
	dt.testprediction(test);

	# print( feature_conditions )
	# for feature in ['satisfaction_level','last_evaluation', 'number_project', 'average_montly_hours','time_spend_company','Work_accident','promotion_last_5years']:
		# rows=len(pd.unique(train[feature]));
		# if ( rows == 0 ):
			# continue
		# if ( rows > 10 ):
			# entropy, conditionset = analyzeDataForRange(train, feature);
			# feature_entropies.append([feature,entropy])
			# feature_conditions[feature] = conditionset
		# else:
			# entropy, conditionset = analyzeDataForDirectValue(train, feature)
			# feature_entropies.append([feature,entropy])
			# feature_conditions[feature] = conditionset

	# for feature in ['Departments', 'salary']:
		# rows=len(pd.unique(train[feature]));
		# if ( rows == 0 ):
			# continue
		# entropy, conditionset = analyzeDataForDirectValue(train, feature)
		# feature_entropies.append([feature,entropy])
		# feature_conditions[feature] = conditionset

	# fe = pd.DataFrame(feature_entropies, columns=['feature', 'entropy']).sort_values('entropy')

	# print(fe)
