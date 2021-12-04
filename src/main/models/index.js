// @ts-check
import { initSchema } from '@aws-amplify/datastore';
import { schema } from './schema';



const { Design, Shot } = initSchema(schema);

export {
  Design,
  Shot
};