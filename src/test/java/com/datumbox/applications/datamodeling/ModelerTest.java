/**
 * Copyright (C) 2013-2015 Vasilis Vryniotis <bbriniotis at datumbox.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.datumbox.applications.datamodeling;

import com.datumbox.common.dataobjects.Dataset;
import com.datumbox.common.dataobjects.Record;
import com.datumbox.common.persistentstorage.interfaces.DatabaseConfiguration;
import com.datumbox.common.utilities.RandomValue;
import com.datumbox.configuration.TestConfiguration;
import com.datumbox.framework.machinelearning.classification.MultinomialNaiveBayes;
import com.datumbox.framework.machinelearning.datatransformation.DummyXMinMaxNormalizer;
import com.datumbox.tests.utilities.TestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author Vasilis Vryniotis <bbriniotis at datumbox.com>
 */
public class ModelerTest {
    
    public ModelerTest() {
    }

    /**
     * Test of train and predict method, of class Modeler.
     */
    @Test
    public void testTrainAndValidate() {
        TestUtils.log(this.getClass(), "testTrainAndValidate");
        RandomValue.setRandomGenerator(new Random(TestConfiguration.RANDOM_SEED));
        DatabaseConfiguration dbConfig = TestUtils.getDBConfig();
        
        
        Dataset trainingData = new Dataset(dbConfig);
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 1.0, 0.0, 1.0, 0.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 1.0, 0.0, 0.0, 1.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 0.0, 1.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 0.0, 1.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 1.0, 0.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 0.0, 1.0, 0.0, 1.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 0.0, 1.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 1.0, 0.0, 1.0, 0.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 1.0, 0.0, 0.0, 1.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 0.0, 1.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 0.0, 1.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 1.0, 0.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 0.0, 1.0, 0.0, 1.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 0.0, 1.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 1.0, 0.0, 1.0, 0.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 1.0, 0.0, 0.0, 1.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 0.0, 1.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 0.0, 1.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 1.0, 0.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 0.0, 1.0, 0.0, 1.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 0.0, 1.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 1.0, 0.0, 1.0, 0.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 1.0, 0.0, 0.0, 1.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 0.0, 1.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 0.0, 1.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 1.0, 0.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 0.0, 1.0, 0.0, 1.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 0.0, 1.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 1.0, 0.0, 1.0, 0.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 1.0, 0.0, 0.0, 1.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 0.0, 1.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 0.0, 1.0}, 1));
        trainingData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 1.0, 0.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 0.0, 1.0, 0.0, 1.0}, 0));
        trainingData.add(Record.newDataVector(new Double[] {1.0, 0.0, 1.0, 0.0, 0.0, 1.0}, 1));
        
        Dataset newData = new Dataset(dbConfig);
        newData.add(Record.newDataVector(new Double[] {0.0, 1.0, 0.0, 1.0, 1.0, 0.0}, 0));
        
        
        
        
        
        
        
        String dbName = "JUnit";
        
        Modeler instance = new Modeler(dbName, dbConfig);
        Modeler.TrainingParameters trainingParameters = new Modeler.TrainingParameters();
        trainingParameters.setkFolds(5);
        
        
        //Model Configuration
        
        trainingParameters.setMLmodelClass(MultinomialNaiveBayes.class);
        MultinomialNaiveBayes.TrainingParameters modelTrainingParameters = new MultinomialNaiveBayes.TrainingParameters();
        modelTrainingParameters.setMultiProbabilityWeighted(true);
        trainingParameters.setMLmodelTrainingParameters(modelTrainingParameters);
        
        /*
        trainingParameters.setMLmodelClass(Kmeans.class);
        Kmeans.TrainingParameters modelTrainingParameters = new Kmeans.TrainingParameters();
        modelTrainingParameters.setK(2);
        modelTrainingParameters.setMaxIterations(200);
        modelTrainingParameters.setInitMethod(Kmeans.TrainingParameters.Initialization.FORGY);
        modelTrainingParameters.setDistanceMethod(Kmeans.TrainingParameters.Distance.EUCLIDIAN);
        modelTrainingParameters.setWeighted(false);
        modelTrainingParameters.setCategoricalGamaMultiplier(1.0);
        modelTrainingParameters.setSubsetFurthestFirstcValue(2.0);
        trainingParameters.setMLmodelTrainingParameters(modelTrainingParameters);
        */

        //data transfomation configuration
        trainingParameters.setDataTransformerClass(DummyXMinMaxNormalizer.class);
        DummyXMinMaxNormalizer.TrainingParameters dtParams = new DummyXMinMaxNormalizer.TrainingParameters();
        trainingParameters.setDataTransformerTrainingParameters(dtParams);
        
        //feature selection configuration
        trainingParameters.setFeatureSelectionClass(null);
        trainingParameters.setFeatureSelectionTrainingParameters(null);
        
        instance.fit(trainingData, trainingParameters);
        
        
        MultinomialNaiveBayes.ValidationMetrics vm = (MultinomialNaiveBayes.ValidationMetrics) instance.validate(trainingData);
        
        double expResult2 = 0.8;
        assertEquals(expResult2, vm.getMacroF1(), TestConfiguration.DOUBLE_ACCURACY_HIGH);
        
        instance = null;
        
        
        TestUtils.log(this.getClass(), "validate");
        
        
        instance = new Modeler(dbName, dbConfig);
        
        instance.validate(newData);
        
        
        
        Map<Integer, Object> expResult = new HashMap<>();
        Map<Integer, Object> result = new HashMap<>();
        for(Integer rId : newData) {
            Record r = newData.get(rId);
            expResult.put(rId, r.getY());
            result.put(rId, r.getYPredicted());
        }
        assertEquals(expResult, result);
        
        instance.erase();
    }
    
}
