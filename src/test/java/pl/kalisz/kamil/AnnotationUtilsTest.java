package pl.kalisz.kamil;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import pl.kalisz.kamil.data.InheritedAnnotatedClass;
import pl.kalisz.kamil.data.TestAnnotation;

/*
 * Copyright (C) 2014 Kamil Kalisz.
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
@RunWith(RobolectricTestRunner.class)
public class AnnotationUtilsTest
{
    @Test
    public void testGetAnnotationFromClassAndSuperclassesTest()
    {
       FieldAnnotationMap<TestAnnotation> fieldAnnotations = AnnotationUtils.getFieldAnnotations(InheritedAnnotatedClass.class, TestAnnotation.class);

        Assert.assertEquals(fieldAnnotations.getFieldsInfo().size(),3);
    }
    
}
