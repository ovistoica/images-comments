/* eslint-disable */
// this is an auto generated file. This will be overwritten

export const onCreateShot = /* GraphQL */ `
  subscription OnCreateShot($owner: String) {
    onCreateShot(owner: $owner) {
      id
      url
      designID
      design {
        id
        name
        context
        shots {
          nextToken
          startedAt
        }
        createdAt
        updatedAt
        _version
        _deleted
        _lastChangedAt
        owner
      }
      createdAt
      updatedAt
      _version
      _deleted
      _lastChangedAt
      owner
    }
  }
`;
export const onUpdateShot = /* GraphQL */ `
  subscription OnUpdateShot($owner: String) {
    onUpdateShot(owner: $owner) {
      id
      url
      designID
      design {
        id
        name
        context
        shots {
          nextToken
          startedAt
        }
        createdAt
        updatedAt
        _version
        _deleted
        _lastChangedAt
        owner
      }
      createdAt
      updatedAt
      _version
      _deleted
      _lastChangedAt
      owner
    }
  }
`;
export const onDeleteShot = /* GraphQL */ `
  subscription OnDeleteShot($owner: String) {
    onDeleteShot(owner: $owner) {
      id
      url
      designID
      design {
        id
        name
        context
        shots {
          nextToken
          startedAt
        }
        createdAt
        updatedAt
        _version
        _deleted
        _lastChangedAt
        owner
      }
      createdAt
      updatedAt
      _version
      _deleted
      _lastChangedAt
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
      shots {
        items {
          id
          url
          designID
          createdAt
          updatedAt
          _version
          _deleted
          _lastChangedAt
          owner
        }
        nextToken
        startedAt
      }
      createdAt
      updatedAt
      _version
      _deleted
      _lastChangedAt
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
      shots {
        items {
          id
          url
          designID
          createdAt
          updatedAt
          _version
          _deleted
          _lastChangedAt
          owner
        }
        nextToken
        startedAt
      }
      createdAt
      updatedAt
      _version
      _deleted
      _lastChangedAt
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
      shots {
        items {
          id
          url
          designID
          createdAt
          updatedAt
          _version
          _deleted
          _lastChangedAt
          owner
        }
        nextToken
        startedAt
      }
      createdAt
      updatedAt
      _version
      _deleted
      _lastChangedAt
      owner
    }
  }
`;
