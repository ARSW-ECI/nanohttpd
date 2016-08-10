package edu.eci.arsw.viewgen.models;

/*
 * #%L
 * NanoHttpd-Webserver
 * %%
 * Copyright (C) 2012 - 2016 nanohttpd
 * %%
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * 3. Neither the name of the nanohttpd nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

import edu.eci.arsw.viewgen.annotations.RelativePosition;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hcadavid
 */
public class SampleViewMetadata {

    public String getTitle() {
        return "The super web-site";
    }

    public String getParagraphOne() {
        return "Sed ut perspiciatis unde omnis iste natus error sit voluptatem " + "accusantium doloremque laudantium, totam rem aperiam, eaque "
                + "ipsa quae ab illo inventore veritatis et quasi architecto " + "beatae vitae dicta sunt explicabo";
    }

    @RelativePosition(border = "3px solid #73AD21",heightInPx = 400,widthInPx = 200)
    public String getParagraphTwo() {
        return "Ut enim ad minima veniam, quis nostrum exercitationem ullam " + "corporis suscipit laboriosam, nisi ut aliquid ex ea " + "commodi consequatur?";
    }

    public List<String> getListOne(){
        LinkedList<String> out=new LinkedList<>();
        for (int i=0;i<10;i++){
            out.add("Element "+i);
        }
        return out;
    }

}
