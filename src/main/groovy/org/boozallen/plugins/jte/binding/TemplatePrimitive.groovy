/*
   Copyright 2018 Booz Allen Hamilton

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package org.boozallen.plugins.jte.binding

import org.boozallen.plugins.jte.config.TemplateConfigObject
import hudson.ExtensionPoint
import hudson.ExtensionList
import jenkins.model.Jenkins 

/*
    A base class for objects that will be stored in the 
    script binding.  Extending this base class will protect
    these objects from being overridden during initialization,
    by library developers, or by pipeline templates.
*/
abstract class TemplatePrimitive implements Serializable, ExtensionPoint{
    // gets called during template initialization
    abstract void throwPreLockException()

    //gets called after template initialization
    abstract void throwPostLockException()

    abstract String getName()

    // used to get all loaders
    static ExtensionList<TemplatePrimitive> all(){
        return Jenkins.getActiveInstance().getExtensionList(TemplatePrimitive)
    }
}