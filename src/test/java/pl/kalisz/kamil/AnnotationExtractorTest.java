package pl.kalisz.kamil;

import org.junit.Assert;
import org.junit.Test;
import pl.kalisz.kamil.data.BaseAnnotatedClass;
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
public class AnnotationExtractorTest
{
    @Test
    public void extractTestAnnotationFromBaseClassTest()
    {
        FieldAnnotationMap<TestAnnotation> extractedAnnotations = AnnotationExtractor.extractFields(BaseAnnotatedClass.class, TestAnnotation.class);

        Assert.assertEquals(extractedAnnotations.getFieldsInfo().size(),2);
    }

    @Test
    public void extractDeprecatedFromBaseClassTest()
    {
        FieldAnnotationMap<Deprecated> extractedAnnotations = AnnotationExtractor.extractFields(BaseAnnotatedClass.class, Deprecated.class);

        Assert.assertEquals(extractedAnnotations.getFieldsInfo().size(),1);
    }
}
