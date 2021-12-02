/* eslint-disable */
// this is an auto generated file. This will be overwritten

export const onCreateTask = /* GraphQL */ `
  subscription OnCreateTask {
    onCreateTask {
      id
      title
      description
      status
      _version
      _deleted
      _lastChangedAt
      createdAt
      updatedAt
    }
  }
`;
export const onUpdateTask = /* GraphQL */ `
  subscription OnUpdateTask {
    onUpdateTask {
      id
      title
      description
      status
      _version
      _deleted
      _lastChangedAt
      createdAt
      updatedAt
    }
  }
`;
export const onDeleteTask = /* GraphQL */ `
  subscription OnDeleteTask {
    onDeleteTask {
      id
      title
      description
      status
      _version
      _deleted
      _lastChangedAt
      createdAt
      updatedAt
    }
  }
`;
export const onCreatePrivateNote = /* GraphQL */ `
  subscription OnCreatePrivateNote($owner: String!) {
    onCreatePrivateNote(owner: $owner) {
      id
      content
      _version
      _deleted
      _lastChangedAt
      createdAt
      updatedAt
      owner
    }
  }
`;
export const onUpdatePrivateNote = /* GraphQL */ `
  subscription OnUpdatePrivateNote($owner: String!) {
    onUpdatePrivateNote(owner: $owner) {
      id
      content
      _version
      _deleted
      _lastChangedAt
      createdAt
      updatedAt
      owner
    }
  }
`;
export const onDeletePrivateNote = /* GraphQL */ `
  subscription OnDeletePrivateNote($owner: String!) {
    onDeletePrivateNote(owner: $owner) {
      id
      content
      _version
      _deleted
      _lastChangedAt
      createdAt
      updatedAt
      owner
    }
  }
`;
export const onCreateDesign = /* GraphQL */ `
  subscription OnCreateDesign($owner: String) {
    onCreateDesign(owner: $owner) {
      id
      name
      context
      _version
      _deleted
      _lastChangedAt
      createdAt
      updatedAt
      owner
    }
  }
`;
export const onUpdateDesign = /* GraphQL */ `
  subscription OnUpdateDesign($owner: String) {
    onUpdateDesign(owner: $owner) {
      id
      name
      context
      _version
      _deleted
      _lastChangedAt
      createdAt
      updatedAt
      owner
    }
  }
`;
export const onDeleteDesign = /* GraphQL */ `
  subscription OnDeleteDesign($owner: String) {
    onDeleteDesign(owner: $owner) {
      id
      name
      context
      _version
      _deleted
      _lastChangedAt
      createdAt
      updatedAt
      owner
    }
  }
`;
