/* ===========================================================================
 * Copyright (C) 2015 CapsicoHealth Inc.
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

package tilda.utils;


public enum HttpStatus
  {
    /*@formatter:off*/
      OK                          (200, "OK")
      
    , BadRequest                  (400, "Bad Request")
    , Unauthorized                (401, "Unauthorized")
    , PaymentRequired             (402, "Payment Required")
    , Forbidden                   (403, "Forbidden")
    , ResourceNotFound            (404, "Resource Not Found")
    
    , MethodNotAllowed            (405, "Method Not Allowed")
    , NotAcceptable               (406, "Not Acceptable")
    , ProxyAuthenticationRequired (407, "Proxy Authentication Required")
    , RequestTimeout              (408, "Request Timeout")
    , Conflict                    (409, "Conflict")
    , Gone                        (410, "Gone")
    , LengthRequired              (411, "Length Required")
    , PreconditionFailed          (412, "Precondition Failed")
    , RequestEntityTooLarge       (413, "Request Entity Too Large")
    , RequestURITooLong           (414, "Request-URI Too Long")
    , UnsupportedMediaType        (415, "Unsupported Media Type")
    , RequestedRangeNotSatisfiable(416, "Requested Range Not Satisfiable")
    , ExpectationFailed           (417, "Expectation Failed")
    
    , InternalServerError         (500, "Internal Server Error")
    , NotImplemented              (501, "Not Implemented")
    , BadGateway                  (502, "Bad Gateway")
    , ServiceUnavailable          (503, "Service Unavailable")
    , GatewayTimeout              (504, "Gateway Timeout")
    , HttpVersionNotSupported     (505, "HTTP Version Not Supported")
    ;
      /*@formatter:on*/

    private HttpStatus(int Code, String Message)
      {
        _Code = Code;
        _Message = Message;
      }

    public final int    _Code;
    public final String _Message;
    
    public static HttpStatus parse(int Code)
      {
        for (HttpStatus e : HttpStatus.values())
          if (e._Code == Code)
            return e;
        return null;
      }
  }
