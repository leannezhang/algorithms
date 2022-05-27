/* Implement the validate function below.
*
* Remember, there are three kinds of validation errors:
*
* {ok: false, message: `${name} is required`}
* {ok: false, message: `type ${type} expected for ${name}`}
* {ok: false, message: `unexpected property ${name}`}
*
* There four possible `types` a property can have:
* string, number, boolean, and array:employee
*/
 

let resultMessage = { ok: false, message: "" };
let schemaKeys = {};

function writeResultMessage(isValid, messageStr) {
   resultMessage['ok']= isValid;
   resultMessage['message'] = messageStr;
   return resultMessage;
}

function containsUnexpectedProperty(rules, employee) {
  for(let rule of rules) {
    schemaKeys[rule.name] = true;
  }
  for (let key in employee) {
    if (!schemaKeys[key]) {
      return key;
    }
  } 
}


function validate(employees, schema) {
 for (let employee of employees) {
    const rules = schema?.employee|| [];
    
    const unexpectedProperty = containsUnexpectedProperty(rules, employee);
    if (unexpectedProperty) {
      return writeResultMessage(false,`unexpected property ${unexpectedProperty}`);
    }

    for( let rule of rules) {
      const { name, required, type } = rule;

      switch(name) {
        case 'reports':
            const reports = employee?.reports;
            if (reports) {
              return validate(reports, schema);
            }
            break;
        case 'subordinates':
            const subordinates = employee?.subordinates;
            if (subordinates) {
              return validate(subordinates, schema);
            }
            break;
        default:
            if (!employee[name] && required) {
                return writeResultMessage(false,`${name} is required`);
            } else if (employee[name] && typeof employee[name] !== type) {
                return writeResultMessage(false, `type ${type} expected for ${name}`);
            }
      }
    }

 }
 return writeResultMessage(true, 'success');
}
 
// Main function
function main(inputString) {
   const {employees, schema} = JSON.parse(inputString);
   const result = validate(employees, schema);
   console.log(result)
}

// Test Data
const employees = `[{
      "name": "Alice",
      "title": "ceo",
      "salary": 123,
      "reports": [{ "name": "Zop", "title": "controller", "salary": 40 }
      ,
      { "name": "Lee", "title": "Manager", "salary": 40,  "reports": [
        {
          "name": "Alex",
          "title": "senior",
          "salary": 34
        }
      ] }
    ]
    }]`;

const schema = `{"employee": [
    {
      "name": "name",
      "required": true,
      "type": "string"
    },
    {
      "name": "title",
      "required": true,
      "type": "string"
    },
    {
      "name": "salary",
      "required": true,
      "type": "number"
    },
    {
      "name": "reports",
      "required": false,
      "type": "array:employee"
    }
  ]
}`

const json = `{"employees": ${employees}, "schema": ${schema}}`;
main(json)
